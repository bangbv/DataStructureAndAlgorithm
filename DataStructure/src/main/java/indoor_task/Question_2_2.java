package indoor_task;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Question_2_2 {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        SparkContext sc = new SparkContext("local", "spark-mysql-test", sparkConf);
        SparkSession spark = new SparkSession(sc);
        Map<String, Double> result = new HashMap<>();

        String sql = "(select * from location20180101) as table_1";

        Dataset<Row> df = spark.read().format("jdbc").option("driver", "com.mysql.cj.jdbc.Driver")
                .option("url", "jdbc:mysql://127.0.0.1:3306/bang_test?useSSL=false").option("user", "root")
                .option("password", "123456").option("dbtable", sql).load();

        Dataset<Row> mac_number = df.select("clientMac").groupBy("clientMac").count();
        List<Row> mac_frequent = mac_number.select("clientMac").where("count > 10").limit(10000000).collectAsList();
        for (Row row : mac_frequent) {
            double pre_p_x, pre_p_y;
            long time_range;
            double distance;
            double moving_speed_average;
            double total_distance = 0;
            LocalDateTime previous_time = null;
            pre_p_x = 0;
            pre_p_y = 0;
            String mac = row.getString(0);
            //System.out.println("mac:" + mac);
            ListIterator<Row> position_list = df.select("x", "y", "timeStamp").where("clientMac = '" + mac + "'").limit(100000).collectAsList().listIterator();
            long total_time = 0;

            while (position_list.hasNext()) {
                Row position = position_list.next();
                double p_x = position.getDecimal(0).doubleValue();
                double p_y = position.getDecimal(1).doubleValue();
                LocalDateTime datetime = position.getTimestamp(2).toLocalDateTime();
                //System.out.println("p_x:" + p_x + "-p_y:" + p_y + "-datetime:" + datetime);
                if (previous_time == null) {
                    time_range = 0;
                    distance = 0;
                } else {
                    Duration duration = Duration.between(previous_time, datetime);
                    time_range = duration.toSeconds();
                    distance = distance(p_x, p_y, pre_p_x, pre_p_y);
                    //System.out.println("time_range:" + time_range+"===="+"distance:" + distance);
                    //System.out.println("moving_range:" + moving_range);
                }

                if (0 < time_range && time_range <= 5) {
                    total_time = total_time + time_range;
                    total_distance = total_distance + distance;
                }
                previous_time = datetime;
                pre_p_x = p_x;
                pre_p_y = p_y;
            }
            if(total_time > 0) {
                moving_speed_average = total_distance / total_time;
                result.put(mac, moving_speed_average);
            }
        }
        spark.close();
        save(result);
    }

    /*
    Haversine
    formula: a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
             c = 2 ⋅ atan2( √a, √(1−a) )
             d = R ⋅ c
    where	φ is latitude, λ is longitude, R is earth’s radius (mean radius = 6,371km);
    note that angles need to be in radians to pass to trig functions!
     */
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double phi = Math.toRadians(lat2 - lat1);
        double lamda = Math.toRadians(lon2 - lon1);
        double R = 6378137;
        double a = (Math.sin(phi / 2) * Math.sin(phi / 2))
                + (Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(Math.toRadians(lamda / 2)) * Math.sin(Math.toRadians(lamda / 2)));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    private static void save(Map<String, Double> result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\workspace\\output_question_2_1.txt"));
            for (Map.Entry<String, Double> entry : result.entrySet()) {
                writer.write("\""+entry.getKey() + "\"," + entry.getValue() + "\n");
                //System.out.println("mac:" + entry.getKey());
                //System.out.println("frequent:" + entry.getValue());
            }
            writer.close();
        } catch (Exception e) {
            // do nothing
        }
    }
}
