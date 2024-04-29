package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {

	public static void main(String[] args) {
		//
		System.out.print("頁: ");
		Scanner scanner = new Scanner(System.in);
		int page = scanner.nextInt();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sql = "SELECT * FROM food LIMIT ?, ?";
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, kw);
			pstmt.setInt(2, kw);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n",id,name);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
