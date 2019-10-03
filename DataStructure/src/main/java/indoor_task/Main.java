package indoor_task;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {

	public static void main(String[] args) {
		int hour = -1;
		int previous_hour = -1;
		long number = 0;
		int range = 0;
		SparkConf sparkConf = new SparkConf();
		SparkContext sc = new SparkContext("local", "spark-mysql-test", sparkConf);
		SparkSession spark = new SparkSession(sc);
		Map<Integer, Long> result = new HashMap<Integer, Long>();

		String sql = "(select * from location20180101) as table_1";

		Dataset<Row> df = spark.read().format("jdbc").option("driver", "com.mysql.cj.jdbc.Driver")
				.option("url", "jdbc:mysql://127.0.0.1:3306/bang_test?useSSL=false").option("user", "root")
				.option("password", "123456").option("dbtable", sql).load();

		Dataset<Row> mac_number = df.select("clientMac").groupBy("clientMac").count();
		List<Row> mac_frequent = mac_number.select("clientMac").where("count > 10").limit(10000000).collectAsList();
		ListIterator<Row> it = mac_frequent.listIterator();
		while (it.hasNext()) {
			Row mac = it.next();
			//System.out.println("mac:"+mac.getString(0));
			Dataset<Row> temp = df.select("timeStamp").where("clientMac = '" + mac.getString(0) + "'");
			// convert to hour
			//System.out.println("timeStamp:"+temp.first());
			ListIterator<Row> timeStamp_list = temp.limit(100000).collectAsList().listIterator();

			while (timeStamp_list.hasNext()) {
				Row timeStamp = timeStamp_list.next();
				Timestamp datetime = timeStamp.getTimestamp(0);
				hour = datetime.toLocalDateTime().getHour();
				//System.out.println("hour:"+hour);
				if (previous_hour < 0) {
					range = 0;
				} else {
					range = hour - previous_hour;
				}
				//System.out.println("range:"+range);
				if (range > 0) {
					if (result.get(range) != null) {
						number = result.get(range);
						number = number + 1;
						result.put(range, number);
					} else {
						result.put(range, (long) 1);
					}
				}
				previous_hour = hour;
			}
			previous_hour = -1;
		}
		spark.close();
		
		for (Entry<Integer, Long> entry : result.entrySet()) {
			System.out.println("range:"+entry.getKey());
			System.out.println("number:"+entry.getValue());
		}
	}
}
