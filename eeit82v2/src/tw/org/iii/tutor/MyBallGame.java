package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBallGame extends JFrame{
	public MyBallGame() {
		
		setLayout(new BorderLayout());
		add(new MyPanel(), BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class MyPanel extends JPanel {
		public MyPanel() {
			setBackground(Color.yellow);
		}
		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
			
			
		}		
	}
	

	
	public static void main(String[] args) {
		new MyBallGame();
	}

}
