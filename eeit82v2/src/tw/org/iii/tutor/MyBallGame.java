package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBallGame extends JFrame{
	private int x, y;
	private Timer timer;
	public MyBallGame() {
		
		setLayout(new BorderLayout());
		add(new MyPanel(), BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		timer = new Timer();
		timer.schedule(new BallTask(), 1*1000, 60);
	}
	
	private class MyPanel extends JPanel {
		public MyPanel() {
			setBackground(Color.YELLOW);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D)g;
			try {
				BufferedImage ball = ImageIO.read(new File("dir4/ball.png"));
				g2d.drawImage(ball, x, y, null);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		}		
	}
	
	private class BallTask extends TimerTask {
		@Override
		public void run() {
			x += 4;
			y += 4;
			repaint();
		}
	}
	

	
	public static void main(String[] args) {
		new MyBallGame();
	}

}
