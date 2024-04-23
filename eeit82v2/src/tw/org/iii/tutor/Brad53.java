package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad53 {

	public static void main(String[] args) {
		String mesg = "資策會";
		byte[] data = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(
					data, 0, data.length,
					InetAddress.getByName("127.0.0.1"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
