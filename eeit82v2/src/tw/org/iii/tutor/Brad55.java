package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad55 {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999)){
			System.out.println("wait...");
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = br.readLine();
			System.out.println(line);
			
			in.close();
			socket.close();
			
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
