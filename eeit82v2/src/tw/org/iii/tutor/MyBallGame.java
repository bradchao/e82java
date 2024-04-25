package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
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
		private LinkedList<BallTask> tasks;
		
		public MyPanel() {
			setBackground(Color.YELLOW);
			
			tasks = new LinkedList<>();
			timer = new Timer();
			timer.schedule(new RefreshView(), 0, 16);
			addMouseListener(new MyMouseListener());
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			viewW = getWidth(); viewH = getHeight();
			
			Graphics2D g2d = (Graphics2D)g;
			for (BallTask task : tasks) {
				g2d.drawImage(task.getImg(), task.getX(), task.getY(), null);
			}
			
		}	
		
		private class MyMouseListener extends MouseAdapter {
			@Override
			public void mousePressed(MouseEvent e) {
				BallTask task = new BallTask(e.getX(), e.getY());
				tasks.add(task);
				timer.schedule(task, 500, 30);
			}
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
		
		public BallTask(int touchX, int touchY) {
			int rand = (int)(Math.random()*4);	// 0 - 3
			img = balls[rand];
			w = img.getWidth(); h = img.getHeight();
			
			x = (int)(touchX - w / 2.0);
			y = (int)(touchY - h / 2.0);
			
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
