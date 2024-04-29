package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
			

			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
