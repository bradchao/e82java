package tw.org.iii.tutor;

import java.awt.FontFormatException;
import java.lang.invoke.LambdaConversionException;

public class Brad38 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		System.out.println(b1.getLeg());
		try {
			b1.setLeg(3);
		}catch(Exception e) {
			System.out.println("setting error");
		}
		System.out.println("end");
	}
}
class Bird {
	private int leg;
	int setLeg(int leg) throws FontFormatException {
		if (leg >= 0 && leg <= 2) {
			this.leg = leg;
		}else {
			throw new FontFormatException(null);
		}
		return this.leg;
	}
	int getLeg() {return this.leg;}
}
class BirdLegException extends Exception {
	@Override
	public String toString() {
		return "Bird Leg Excetopn";
	}
}
