package tw.org.iii.jdbc;

import tw.org.iii.apis.BCrypt;

public class JDBC09 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hwPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hwPasswd);
		String input = "123456";
		
		if (BCrypt.checkpw(input, hwPasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	}

}
