package ApiCaller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiCaller {

	private String issLocationTracker = "http://api.open-notify.org/iss-now.json";
	
	public JSONObject getJsonFromUrl(String address) throws IOException {
		URL url = new URL(address);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String input;
		StringBuffer response = new StringBuffer();
		
		while((input = bufferedReader.readLine()) != null) {
			response.append(input);
		}
		
		bufferedReader.close();
		
		JSONObject obj = new JSONObject(response.toString());
		JSONObject jArray = obj.getJSONObject("iss_position");
		
		System.out.println(jArray.getDouble("latitude"));

		
		return obj;
	}
}
