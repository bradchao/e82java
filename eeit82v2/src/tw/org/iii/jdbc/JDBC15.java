package tw.org.iii.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.imageio.ImageIO;

import tw.org.iii.apis.Bike;

public class JDBC15 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String QUERY_SQL = 
		"SELECT * FROM member WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(QUERY_SQL);
			pstmt.setInt(1, 1);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream is = rs.getBinaryStream("bike");
				//---------------
				ObjectInputStream oin = new ObjectInputStream(is);
				Object obj = oin.readObject();
				if (obj instanceof Bike) {
					Bike b2 = (Bike)obj;
					System.out.println(b2);
				}
				
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
