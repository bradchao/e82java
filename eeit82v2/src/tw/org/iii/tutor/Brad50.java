package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad50 {

	public static void main(String[] args) {
		Brad503 obj = new Brad503();
		try (ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("dir1/test1.obj"))){
			oout.writeObject(obj);
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("----");
		try(ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("dir1/test1.obj"))){
			oin.readObject();
		}catch(Exception e) {
			System.out.println(e);
		}		

	}
}
class Brad501  implements Serializable {
	Brad501(){System.out.println("Brad501()");}
}
class Brad502 extends Brad501{
	Brad502(){System.out.println("Brad502()");}
}
class Brad503 extends Brad502 {
	Brad503(){System.out.println("Brad503()");}
}








