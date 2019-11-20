package indoor_task;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UJIIndoorLoc_analytics_2 {

    public static void main(String[] args) throws Exception {
        SparkConf sparkConf = new SparkConf();
        SparkContext sc = new SparkContext("local", "spark-mysql-test", sparkConf);
        SparkSession spark = new SparkSession(sc);

        String sql = "(select * from location20180101) as table_1";

        Dataset<Row> df = spark.read().format("csv").option("header", "true").load("C:\\Users\\RC46FW\\Documents\\data\\Data_Set\\IPIN2016\\1485881443_7042618_Train.csv");
        df.createTempView("my_table");
        //Dataset<Row> user = df.select("TIMESTAMP").where("USERID = 1").limit(1);
        Dataset<Row> user = df.select("TIMESTAMP","LONGITUDE", "LATITUDE").where("USERID = 1").limit(100000);
        user.show();
//        for (Row row : user.collectAsList()) {
//            String time = row.getString(0);
//            System.out.println(time);
//        }
        for (Row row : user.collectAsList()) {
            String time = row.getString(0);
            //Timestamp datetime = new Timestamp(Long.parseLong(time));
            // convert seconds to milliseconds
            Date date = new Date(Long.parseLong(time) * 1000L);
            // the format of your date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            // give a timezone reference for formatting (see comment at the bottom)
            sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
            String formattedDate = sdf.format(date);
            System.out.println(formattedDate +"|"+ row.get(1)+"|"+row.get(1));
        }
        spark.close();
    }
}
