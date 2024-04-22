package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Brad41 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/brad1.txt");
			
			int len; byte[] buf = new byte[3];
			while ( (len = fin.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}
			
			fin.close();
			//System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
