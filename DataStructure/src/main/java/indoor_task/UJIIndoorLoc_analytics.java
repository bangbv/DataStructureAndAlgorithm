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

public class UJIIndoorLoc_analytics {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        SparkContext sc = new SparkContext("local", "spark-mysql-test", sparkConf);
        SparkSession spark = new SparkSession(sc);
        Map<String, Double> result = new HashMap<>();

        String sql = "(select * from location20180101) as table_1";

        Dataset<Row> df = spark.read().format("csv").option("header", "true").load("C:\\Users\\RC46FW\\Documents\\data\\1485881443_7042618_Train.csv");

        Dataset<Row> mac_number = df.select("LONGITUDE","LATITUDE","TIMESTAMP","PHONEID").limit(20);
        mac_number.show();
        spark.close();
    }
}
