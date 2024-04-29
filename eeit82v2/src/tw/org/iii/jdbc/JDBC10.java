package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.org.iii.apis.BCrypt;

public class JDBC10 {

	public static void main(String[] args) {
		String account = "amy";
		String passwd = "123456";
		String realname = "艾米";
		
		String hwPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		
		String sql = "INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, account);
			pstmt.setString(2, hwPasswd);
			pstmt.setString(3, realname);
			pstmt.executeUpdate();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
