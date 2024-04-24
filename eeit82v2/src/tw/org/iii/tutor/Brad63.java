package tw.org.iii.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad63 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Task1 t1 = new Task1();
		StopTask s1 = new StopTask(timer);
		timer.schedule(t1, 100, 100);
		timer.schedule(s1, 3*1000);
		System.out.println("main");
		
	}

}

class Task1 extends TimerTask{
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
class StopTask extends TimerTask{
	private Timer timer;
	StopTask(Timer timer){
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}







