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

        String sql = "select count(*) from global_temp.my_table group by LONGITUDE,LATITUDE";

        //String path = "C:\\Users\\RC46FW\\Google Drive\\PhD\\data\\Data_Set\\UJIIndoor_Loc\\1478167720_9233432_trainingData.csv"; //UJIIndoor_Loc
        String path = "C:\\Users\\RC46FW\\Google Drive\\PhD\\data\\Data_Set\\IPIN2016\\1485881443_7042618_Train.csv"; //IPIN2016
        //String path = "C:\\Users\\RC46FW\\Google Drive\\PhD\\data\\Data_Set\\Tampere_University\\TAMPERE1_training.csv"; //Tampere_University
        //String path = "C:\\Users\\RC46FW\\Google Drive\\PhD\\data\\Data_Set\\Alcala_Tutorial_2017\\1490779198_4046512_alc2017_training_set.csv"; //Alcala_Tutorial_2017

        Dataset<Row> df = spark.read().format("csv").option("header", "true").load(path);
        df.createGlobalTempView("my_table");
        //Dataset<Row> user = df.select("LONGITUDE","LATITUDE").groupBy("LONGITUDE","LATITUDE").count();
        Dataset<Row> user = df.select("*").limit(4);
        //spark.sql(sql).show();
        //long result = 0;
        user.show();
        //System.out.println(result);
//        for (Row row : user.collectAsList()) {
//            String time = row.getString(0);
//            //Timestamp datetime = new Timestamp(Long.parseLong(time));
//            // convert seconds to milliseconds
//            Date date = new Date(Long.parseLong(time) * 1000L);
//            // the format of your date
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//            // give a timezone reference for formatting (see comment at the bottom)
//            sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
//            String formattedDate = sdf.format(date);
//            System.out.println(formattedDate +"|"+ row.get(1)+"|"+row.get(2));
//        }
        spark.close();
    }
}
