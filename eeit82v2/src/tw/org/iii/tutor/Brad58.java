package tw.org.iii.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad58 {

	public static void main(String[] args) {
		while (true) {
			try (ServerSocket server = new ServerSocket(6666)){
				System.out.println("wait...");
				Socket socket = server.accept();
				InputStream in = socket.getInputStream();
				
				String urip = socket.getInetAddress().getHostAddress();
				String filename = String.format("dir3/%s.jpg", urip);
				
				BufferedOutputStream bout = 
					new BufferedOutputStream(
						new FileOutputStream(filename));
				
				byte[] buf = new byte[4*1024*1024]; int len;
				while ( (len = in.read(buf)) != -1) {
					bout.write(buf, 0, len);
				}
				
				bout.flush();
				bout.close();
				
				in.close();
				socket.close();
				
				System.out.println("OK");
			}catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
