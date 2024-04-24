package tw.org.iii.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;
	
	public Racing() {
		super("Racing");
		
		setLayout(new GridLayout(9, 1));
		go = new JButton("Go!"); add(go);
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel(String.format("%d.", (i+1)));
			add(lanes[i]);
		}
		
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		
		cars = new Car[8];
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void go() {
		go.setEnabled(false);
		initGame();
		for(int i=0; i<cars.length; i++) cars[i] = new Car(i);
		for (int i = 0; i<cars.length; i++) {
			cars[i].start();
		}
	}
	
	private void initGame() {
		for (int i=0; i<lanes.length; i++) {
			lanes[i].setText(String.format("%d.", (i+1)));
		}
		rank = 0;
	}
	
	class Car extends Thread {
		private int lane;
		Car(int lane){
			this.lane = lane;
		}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				if (i == 99) {
					lanes[lane].setText(lanes[lane].getText() + "> WINNER" );
					stopGame();
				}else {
					lanes[lane].setText(lanes[lane].getText() + ">");					
				}
				try {
					Thread.sleep(10 + (int)(Math.random()*200));
				} catch (InterruptedException e) {
					//
					break;
				}
			}
		}
	}
	
	private void stopGame() {
		for (int i=0; i<cars.length; i++) {
			cars[i].interrupt();
		}
		go.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new Racing();
	}
}
