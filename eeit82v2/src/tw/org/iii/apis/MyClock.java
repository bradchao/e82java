package tw.org.iii.apis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	private int i;
	
	public MyClock() {
		timer = new Timer();
		timer.schedule(new ClockTask(), 0, 100);
	}

	private class ClockTask extends TimerTask {
		@Override
		public void run() {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			setText(sdf.format(now));			
		}
	}
}
