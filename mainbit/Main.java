package mainbit;

import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			//new httptest().sendGET("http://www.readcomics.tv/dc-universe-rebirth/chapter-1/full");
			//new httptest().sendGET("http://localhost/scrappertest/div.html");
			
			new HTTPRequest().sendGET("http://wiki.climbing.ie/index.php/Winter_Climbing_Glenariff");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
