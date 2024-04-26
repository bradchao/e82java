package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {
	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);

			Statement stmt =  conn.createStatement();
			int n = stmt.executeUpdate(
					"INSERT INTO cust (cname, tel, birthday) VALUES" + 
					" ('brada','123','1999-01-02')," +
					" ('bradb','123','1999-01-02')," +
					" ('bradc','123','1999-01-02')"
						);
			System.out.println(n);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
