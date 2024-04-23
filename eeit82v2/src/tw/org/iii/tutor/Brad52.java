package tw.org.iii.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad52 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("10.0.103.50");
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}

	}

}
