package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		//
		System.out.print("關鍵字: ");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		String kw = "%" + key + "%";
		
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sql = "SELECT * FROM food WHERE name LIKE ? OR addr LIKE ? OR city LIKE ? OR town LIKE ?";
		// jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;user=MyUserName;password=*****;encrypt=false;
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, kw);
			pstmt.setString(2, kw);
			pstmt.setString(3, kw);
			pstmt.setString(4, kw);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String city = rs.getString("city");
				String town = rs.getString("town");
				System.out.printf("%s:%s:%s:%s\n",name,addr,city,town);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
