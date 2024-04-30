package tw.org.iii.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.imageio.ImageIO;

public class JDBC13 {
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
				InputStream is = rs.getBinaryStream("icon");
				
				//--------------
				FileOutputStream fout = new FileOutputStream("dir5/brad.jpg");
				byte[] buf = new byte[128*1024];
				int len = is.read(buf);
				fout.write(buf, 0, len);
				fout.flush();
				fout.close();
				
				is.close();
				System.out.println("OK");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
