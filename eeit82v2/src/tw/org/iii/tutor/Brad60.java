package tw.org.iii.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad60 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://p2.bahamut.com.tw/B/2KU/75/67946dfa9d725b67dde402d82b1pp1n5.JPG?w=1000");
			URLConnection urlConnection = url.openConnection();
			HttpsURLConnection conn = (HttpsURLConnection)urlConnection;
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir3/gamer.jpg"));

			byte[] buf = new byte[4*1024*1024]; int len;
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
		
			bin.close();
			
			System.out.println("download ok");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
