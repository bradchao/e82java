package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad44 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/coffee1.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/coffee3.jpg");
			
			int len; byte[] buf = new byte[4*1024];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
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
