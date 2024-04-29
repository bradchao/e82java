package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC06 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sql = "SELECT * FROM food";
		// jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;user=MyUserName;password=*****;encrypt=false;
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				){
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Double lat = rs.getDouble("lat");
				Double lng = rs.getDouble("lng");
				System.out.printf("%s : %s : %f : %f\n", id, name, lat, lng);
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
