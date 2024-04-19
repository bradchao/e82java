package tw.org.iii.tutor;

import java.io.File;

public class Brad33 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File file = new File("c:/brad/test1");
		System.out.println(file.exists());
		System.out.println("---");
		File f1 = new File(".");
		System.out.println(f1.getAbsolutePath());
		File f2 = new File("./dir4");
		System.out.println(f2.exists());
		
		

	}

}
