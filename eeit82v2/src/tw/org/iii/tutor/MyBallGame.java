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
	private BufferedImage[] balls;
	private int viewW, viewH;
	
	public MyBallGame() {
		
		balls = new BufferedImage[4];
		try {
			balls[0] = ImageIO.read(new File("dir4/ball0.png"));
			balls[1] = ImageIO.read(new File("dir4/ball1.png"));
			balls[2] = ImageIO.read(new File("dir4/ball2.png"));
			balls[3] = ImageIO.read(new File("dir4/ball3.png"));
		}catch(Exception e) {
			System.out.println(e); System.exit(0);
		}
		
		
		setLayout(new BorderLayout());
		add(new MyPanel(), BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private class MyPanel extends JPanel {
		private Timer timer;
		
		public MyPanel() {
			setBackground(Color.YELLOW);
			timer = new Timer();
			timer.schedule(new RefreshView(), 0, 16);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			viewW = getWidth(); viewH = getHeight();
			
			Graphics2D g2d = (Graphics2D)g;
			
			
		}	
		
		private class RefreshView extends TimerTask {
			@Override
			public void run() {
				repaint();
			}
		}
		
		
	}
	
	
	private class BallTask extends TimerTask {
		private int x, y, w, h, dx, dy;
		private BufferedImage img;
		
		public BallTask(int x, int y) {
			this.x = x; this.y = y;
			int rand = (int)(Math.random()*4);	// 0 - 3
			img = balls[rand];
			w = img.getWidth(); h = img.getHeight();
			dx = (int)(Math.random()*17) - 8;
			dy = (int)(Math.random()*17) - 8;
		}
		
		@Override
		public void run() {
			if (x + w >= viewW || x <= 0) {
				dx *= -1;
			}
			if (y + h >= viewH || y <= 0) {
				dy *= -1;
			}
			x += dx;
			y += dy;
		}
		public int getX() {return x;}
		public int getY() {return y;}
		public BufferedImage getImg() {return img;}
	}
	
	public static void main(String[] args) {
		new MyBallGame();
	}

}
