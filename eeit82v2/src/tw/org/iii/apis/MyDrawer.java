package tw.org.iii.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	private LinkedList<Line> lines;
	
	public MyDrawer() {
		lines = new LinkedList<>();
		
		setBackground(Color.yellow);
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(4));

		for (Line line : lines) {
			for (int i=1; i<line.size(); i++) {
				Point p0 = line.getPoint(i-1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
		
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			Line line = new Line(Color.blue, 4);
			
			line.addPoint(point);;
			lines.add(line);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(point);;
			
			repaint();
		}
	}
	
	
	
	
}
