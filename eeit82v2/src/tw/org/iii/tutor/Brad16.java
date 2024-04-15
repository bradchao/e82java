package tw.org.iii.tutor;

import tw.org.iii.apis.Bike;
import tw.org.iii.apis.Scooter;

public class Brad16 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter("white");
		Bike b1 = new Bike();
		s1.chGear(2);
		s1.upSpeed();s1.upSpeed();s1.upSpeed();s1.upSpeed();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(s1.getSpeed());
		System.out.println(b1.getSpeed());
		System.out.println(s1.getColor());


	}

}
