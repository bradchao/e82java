package tw.org.iii.tutor;

import java.io.File;
import java.io.IOException;

public class Brad34 {

	public static void main(String[] args) {
		File f1 = new File("dir1");
		File f2 = new File("C:\\Users\\User\\git\\repository\\eeit82v2\\dir1");
		File f3 = new File("dir1");
		File f4 = new File("./dir1");
		System.out.println(f1.equals(f2));
		System.out.println(f1.equals(f4));
		File f5 = new File("dir4");
		if (!f5.exists()) {
			f5.mkdir();
		}
		File f6 = new File("dir1/dir2/dir3/dir4");
		if (!f6.exists()) {
			f6.mkdirs();
		}
		File f7 = new File("dir1/file2.txt");
		File f8 = new File("dir2/file3.txt");
		f7.renameTo(f8);
		
		File f9 = new File("dir1");
		System.out.println(f9.canWrite());
		System.out.println("---");
		
		File fa = new File("dir5");
		fa.mkdir();
		File fb = new File("dir5/file1.txt");
		try {
			fb.createNewFile();
		} catch (IOException e) {

		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
