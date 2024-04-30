package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC16 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String QUERY_SQL = "SELECT * FROM food";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(
					QUERY_SQL,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n",id, name);
			}
			System.out.println("---");
			if (rs.first()) {
				//System.out.println("OK");
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n",id, name);
				
				rs.absolute(5);	// 1-base
				id = rs.getString("id");
				name = rs.getString("name");
				System.out.printf("%s:%s\n",id, name);
				
				rs.updateString("tel", "04-12345678");
				rs.updateString("city", "台中市");
				rs.updateRow();
				
				//rs.deleteRow();
				
				rs.moveToInsertRow();
				rs.updateString("tel", "04-12345678");
				rs.updateString("name", "不來的大飯店");
				rs.insertRow();
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}
}
