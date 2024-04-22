package tw.org.iii.apis;

import java.io.Serializable;

public class Bike extends Object implements Serializable {
	protected double speed;
	
	public void upSpeed() {
		speed = speed < 1? 1 : speed * 1.2;
	}
	
	public void downSpeed() {
		speed = speed < 1? 0 : speed * 0.7;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	
	public String toString() {
		return String.format("Speed is %f", speed);
	}
	
}
