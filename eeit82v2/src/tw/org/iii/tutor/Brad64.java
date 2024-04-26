package tw.org.iii.tutor;

public class Brad64 {

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				download();
			}
		}.start();
		
		
		
	}
	static void download() {
		
	}

}
