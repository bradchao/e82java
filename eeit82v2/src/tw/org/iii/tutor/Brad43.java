package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad43 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/coffee1.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/coffee1.jpg");
			
			int d;
			while ((d = fin.read()) != -1) {
				fout.write(d);
			}
			
			fout.flush();
			fout.close();
			fin.close();
			System.out.println("finish");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);
		
	}
}
