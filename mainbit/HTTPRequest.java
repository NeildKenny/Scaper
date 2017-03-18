package mainbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class HTTPRequest {

	private final String USER_AGENT = "Mozilla/5.0";
	
	
	public void sendGET(String url) throws IOException{
		URL url_obj;
		
		url_obj = new URL(url);

		HttpURLConnection conn = (HttpURLConnection) url_obj.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", USER_AGENT );
		
		int response_code = conn.getResponseCode(); 
		
		System.out.println(response_code);
		
		BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
		ArrayList<String> site_as_string = new ArrayList<String>();
		String line;
		while((line = in.readLine())!=null){
			site_as_string.add(line);
		}
		in.close();
		
		Find find = new Find();
		find.findAllOccurances(site_as_string, "<img");
		
		
	
	
	}
	

	
}
