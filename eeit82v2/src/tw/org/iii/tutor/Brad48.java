package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import tw.org.iii.apis.Bike;

public class Brad48 {

	public static void main(String[] args) {
		
		try {
			ObjectInputStream oin = 
				new ObjectInputStream(new FileInputStream("dir1/brad.obj"));
			Object obj =  oin.readObject();
			if (obj instanceof Bike) {
				Bike b1 = (Bike)obj;
				System.out.println(b1);
			}else {
				System.out.println("XX");
			}
			oin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
