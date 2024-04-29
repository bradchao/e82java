package tw.org.iii.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JDBC05 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ( (line=reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		
	}
	
	

}
