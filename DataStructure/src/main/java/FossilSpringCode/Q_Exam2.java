package FossilSpringCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Q_Exam2 {
	public static void main(String[] args) throws Exception {
		String[] result = getMovieTitles("spiderman");
		Arrays.sort(result);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	static String[] getMovieTitles(String substr) {
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
		String response = null;
		response = getUrl(url);
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject) jsonParser.parse(response.toString());
		int total_pages = jo.get("total_pages").getAsInt();
		int total = jo.get("total").getAsInt();
		String[] result = new String[total];
		int j = 0;
		int i = 0;
		for (i = 1; i <= total_pages; i++) {

			url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + String.valueOf(i);
			response = getUrl(url);
			jo = (JsonObject) jsonParser.parse(response.toString());
			JsonArray data = (JsonArray) jo.get("data");
			for (int x = 0; x < data.size(); x++) {
				JsonObject t = (JsonObject) data.get(x);
				result[j++] = t.get("Title").getAsString();
			}
		}
		return result;
	}

	static String getUrl(String url) {
		final String USER_AGENT = "Mozilla/5.0";
		StringBuffer response = new StringBuffer();
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response.toString();
	}
}
