package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad57 {

	public static void main(String[] args) {
		
		try {
			// read file content
			File file = new File("dir1/coffee1.jpg");
			byte[] buf = new byte[(int)file.length()];
			FileInputStream fin = new FileInputStream(file);
			fin.read(buf);
			fin.close();
			
			
			Socket socket = new Socket(InetAddress.getByName("10.0.103.50"), 6666);
			OutputStream out = socket.getOutputStream();
			
			out.write(buf);
			
			out.flush();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
