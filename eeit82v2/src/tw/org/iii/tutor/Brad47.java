package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tw.org.iii.apis.Bike;

public class Brad47 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1);
		try (FileOutputStream fout = new FileOutputStream("dir1/brad.obj");
			ObjectOutputStream oout = new ObjectOutputStream(fout);){
			
			oout.writeObject(b1);
			
			oout.flush();
			//oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
