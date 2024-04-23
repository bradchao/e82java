package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad54 {

	public static void main(String[] args) {
		while(true) {
			byte[] buf = new byte[4*1024];
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				//System.out.println("wait...");
				socket.receive(packet);
				socket.close();
				
				String urip = packet.getAddress().getHostAddress();
				byte[] data = packet.getData();
				int len = packet.getLength();
				String mesg = new String(data, 0, len);
				System.out.printf("%s : %s\n" , urip, mesg);
				if (mesg.trim().equals("bye")) {
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
