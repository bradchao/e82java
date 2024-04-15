package tw.org.iii.apis;

public class Scooter extends Bike {
	private int gear;
	
	
	public int chGear(int gear) {
		if (gear >= 0 && gear <= 4) {
			this.gear = gear;
		}
		return this.gear;
	}
	
	public void upSpeed() {
		speed = speed < 1? 1 : speed * 1.8 * gear;
	}
}
