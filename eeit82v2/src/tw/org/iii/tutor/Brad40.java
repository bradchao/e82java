package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad40 {

	public static void main(String[] args) {
		String data = "\n1234567";
		byte[] buf = data.getBytes();
		try {
			FileOutputStream fout = new FileOutputStream("dir1/brad1.txt", true);
			fout.write(buf);
			fout.flush();
			fout.close();
			System.out.println("OK");
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
