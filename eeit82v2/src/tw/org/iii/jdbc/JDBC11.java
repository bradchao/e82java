package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.apis.BCrypt;

public class JDBC11 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");		
		
		System.out.print("Account: ");
		Scanner scanner = new Scanner(System.in);
		String inputAccount = scanner.next();
		System.out.print("Password: ");
		String inputPasswd = scanner.next();
		
		String sql = "SELECT * FROM member WHERE account = ?";
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputAccount);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hwPasswd = rs.getString("passwd");
				if (BCrypt.checkpw(inputPasswd, hwPasswd)) {
					String realname = rs.getString("realname");
					System.out.printf("Welcome, %s", realname);
				}else {
					// Passwd ERROR
					System.out.println("Passwd ERROR");
				}
			}else {
				// Account ERROR
				System.out.println("Account ERROR");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
