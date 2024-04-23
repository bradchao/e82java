package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad59 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.iii.org.tw");
			URLConnection urlConnection = url.openConnection();
			HttpsURLConnection conn = (HttpsURLConnection)urlConnection;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
