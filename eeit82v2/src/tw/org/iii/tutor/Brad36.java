package tw.org.iii.tutor;

import java.io.File;
import java.io.IOException;

public class Brad36 {

	public static void main(String[] args) {
		File f1 = new File("dir1/brad.txt");
		try {
			if (f1.createNewFile()) {
				
			}
		} catch (IOException e) {

		}
	}

}
