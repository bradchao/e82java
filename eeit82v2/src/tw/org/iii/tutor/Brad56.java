package tw.org.iii.tutor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad56 {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.103.50"), 9999);
			OutputStream out = socket.getOutputStream();
			
			out.write("Hello, World".getBytes());
			
			out.flush();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
