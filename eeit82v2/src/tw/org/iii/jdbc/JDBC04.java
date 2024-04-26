package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04 {
	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);

			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "tony");
			pstmt.setString(2, "456");
			pstmt.setString(3, "1997-02-03");
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
