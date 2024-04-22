package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;

public class Brad42 {
	public static void main(String[] args) {
		try {
			File f1 = new File("dir1/brad1.txt");
			FileInputStream fin = new FileInputStream(f1);
			
			byte[] buf = new byte[(int)f1.length()];
			fin.read(buf);
			System.out.println(new String(buf));

			
			fin.close();
			//System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
