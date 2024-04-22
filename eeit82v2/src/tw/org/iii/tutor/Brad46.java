package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad46 {

	public static void main(String[] args) {
		try {
//			FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv");
//			InputStreamReader in = new InputStreamReader(fin);
			FileReader fr = new FileReader("dir1/ns1hosp.csv");
			BufferedReader reader = new BufferedReader(fr);

			String line;
			reader.readLine();
			while ( (line = reader.readLine()) != null) {
				String[] data = line.split(",");
				System.out.printf("%s : %s : %s : %s\n", 
						data[2], data[5], data[6], data[7]);
				//System.out.println("---");
			}
			
			
			reader.close();
			System.out.println("finish");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
