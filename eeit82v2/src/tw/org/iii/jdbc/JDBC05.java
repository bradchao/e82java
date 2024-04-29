package tw.org.iii.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

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
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop)){
			
			String sql = "INSERT INTO food (name,addr,tel,city,town,picurl,lat,lng)" + 
			" VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				String city = row.getString("City");
				String town = row.getString("Town");
				String picurl = row.getString("PicURL");
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, tel);
				pstmt.setString(4, city);
				pstmt.setString(5, town);
				pstmt.setString(6, picurl);
				
				try {
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(7, 0.0);
					pstmt.setDouble(8, 0.0);
				}
				
				pstmt.executeUpdate();
				
			}
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
