package tw.org.iii.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	public MyDrawer() {
		setBackground(Color.yellow);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("OK1");
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(10));
		g2d.drawLine(0, 0, 200, 400);

	
	}
	
}
