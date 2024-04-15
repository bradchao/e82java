package tw.org.iii.apis;

public class Scooter extends Bike {
	private int gear;
	private String color = "red";
	
//	public Scooter() {
//		color = "red";
//	}
	public Scooter(String color) {
		// super();
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
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
