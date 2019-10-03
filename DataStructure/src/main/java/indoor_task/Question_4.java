package indoor_task;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;

public class Question_4 {

    public static void main(String[] args) {
        LocalDateTime previous_time = null;
        LocalDateTime first_time = null;
        long range;
        SparkConf sparkConf = new SparkConf();
        SparkContext sc = new SparkContext("local", "spark-mysql-test", sparkConf);
        SparkSession spark = new SparkSession(sc);
        Map<String, Long> result = new HashMap<>();

        String sql = "(select * from location20180101) as table_1";

        Dataset<Row> df = spark.read().format("jdbc").option("driver", "com.mysql.cj.jdbc.Driver")
                .option("url", "jdbc:mysql://127.0.0.1:3306/bang_test?useSSL=false").option("user", "root")
                .option("password", "123456").option("dbtable", sql).load();

        Dataset<Row> mac_number = df.select("clientMac").groupBy("clientMac").count();
        List<Row> mac_frequent = mac_number.select("clientMac").where("count > 10").limit(10000000).collectAsList();
        for (Row row : mac_frequent) {
            String mac = row.getString(0);
            //System.out.println("mac:"+mac.getString(0));
            ListIterator<Row> timeStamp_list = df.select("timeStamp").where("clientMac = '" + mac + "'").limit(100000).collectAsList().listIterator();
            long row_number = 0;
            long total_time = 0;

            while (timeStamp_list.hasNext()) {
                row_number++;
                Row timeStamp = timeStamp_list.next();
                LocalDateTime datetime = timeStamp.getTimestamp(0).toLocalDateTime();
                if (previous_time == null) {
                    range = 0;
                    first_time = datetime;
                } else {
                    Duration duration = Duration.between(previous_time, datetime);
                    //System.out.println("Seconds:" + duration.toSeconds());
                    range = duration.toSeconds();
                }

                if (range > 1200) {
                    Duration range_duration = Duration.between(first_time, previous_time);
                    total_time = total_time + range_duration.toSeconds();
                    first_time = datetime;
                }
                previous_time = datetime;
            }
            Duration range_duration = Duration.between(first_time, previous_time);
            total_time = total_time + range_duration.toSeconds();
            long frequent = total_time / row_number;
            result.put(mac, frequent);
            previous_time = null;
            break;
        }
        
        spark.close();

//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\RC46FW\\workspace\\output.txt"));
//            for (Entry<String, Long> entry : result.entrySet()) {
//                writer.write(entry.getKey() + "  " + entry.getValue() + "\n");
//                //System.out.println("mac:" + entry.getKey());
//                //System.out.println("frequent:" + entry.getValue());
//            }
//            writer.close();
//        } catch (Exception e){
//            // do nothing
//        }
    }
}
