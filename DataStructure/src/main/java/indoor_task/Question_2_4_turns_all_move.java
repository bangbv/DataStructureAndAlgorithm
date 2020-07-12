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

public class Question_2_4_turns_all_move {

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
            double pre_p_x = 0, pre_p_y = 0;
            long time_range, next_time_range = 0;
            int consecutive = 0;
            double distance_a, distance_b, distance_c;
            double moving_speed, n_moving_speed, all_move = 0, angle, turns = 0;
            LocalDateTime previous_time = null;
            String mac = row.getString(0);
            //System.out.println("mac:" + mac);
            ListIterator<Row> position_list = df.select("x", "y", "timeStamp").where("clientMac = '" + mac + "'").limit(100000).collectAsList().listIterator();

            Row next_pos = null;
            while (position_list.hasNext()) {
                Row current_pos;
                if (next_pos == null) {
                    current_pos = position_list.next();
                } else {
                    current_pos = next_pos;
                }
                if (position_list.hasNext()) {
                    next_pos = position_list.next();
                    double p_x = current_pos.getDecimal(0).doubleValue();
                    double p_y = current_pos.getDecimal(1).doubleValue();
                    double next_p_x = next_pos.getDecimal(0).doubleValue();
                    double next_p_y = next_pos.getDecimal(1).doubleValue();
                    LocalDateTime datetime = current_pos.getTimestamp(2).toLocalDateTime();
                    LocalDateTime next_datetime = next_pos.getTimestamp(2).toLocalDateTime();
                    if (previous_time == null) {
                        time_range = 0;
                    } else {
//                        Duration duration = Duration.between(previous_time, datetime);
//                        time_range = duration.toSeconds();
//                        Duration next_duration = Duration.between(datetime, next_datetime);
//                        next_time_range = next_duration.toSeconds();
                        time_range = 0;
                        next_time_range = 0;
                        //System.out.println("time_range:" + time_range+"===="+"distance:" + distance);
                        //System.out.println("moving_range:" + moving_range);
                    }

                    if (0 < time_range && time_range <= 10 && next_time_range < 10) {
                        distance_a = distance(p_x, p_y, pre_p_x, pre_p_y);
                        distance_b = distance(p_x, p_y, next_p_x, next_p_y);
                        distance_c = distance(pre_p_x, pre_p_y, next_p_x, next_p_y);
                        moving_speed = distance_a / time_range;
                        n_moving_speed = distance_b / next_time_range;
                        if (moving_speed >= 1000 && n_moving_speed >= 1000) {
                            consecutive++;
                            // caculate angle
                            angle = Math.toDegrees(
                                    Math.acos((Math.pow(distance_a, 2) + Math.pow(distance_b, 2) - Math.pow(distance_c, 2)) / (2 * distance_a * distance_b)));
                            // turns
                            if (angle > 90) {
                                turns++;
                            }
                        }
                    } else {
                        if (consecutive > 0)
                            all_move++;
                        consecutive = 0;
                    }
                    previous_time = datetime;
                    pre_p_x = p_x;
                    pre_p_y = p_y;
                }
            }
            if (all_move > 0) {
                double ratio = turns / all_move;
                result.put(mac, ratio);
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\RC46FW\\workspace\\output_question24_all_move.txt"));
            for (Map.Entry<String, Double> entry : result.entrySet()) {
                writer.write("\"" + entry.getKey() + "\"," + entry.getValue() + "\n");
                //System.out.println("mac:" + entry.getKey());
                //System.out.println("frequent:" + entry.getValue());
            }
            writer.close();
        } catch (Exception e) {
            // do nothing
        }
    }
}
