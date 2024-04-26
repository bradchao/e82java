package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii?user=root&password=root");

			Statement stmt =  conn.createStatement();
			int n = stmt.executeUpdate(
					"INSERT INTO cust (cname, tel, birthday) VALUES" + 
					" ('brad1','123','1999-01-02')," +
					" ('brad2','123','1999-01-02')," +
					" ('brad3','123','1999-01-02')"
						);
			System.out.println(n);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
