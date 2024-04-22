package tw.org.iii.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawerV2 extends JPanel{
	private LinkedList<LineV2> lines, rbin;
	private Color defColor;
	private int width;
	
	public MyDrawerV2() {
		lines = new LinkedList<>();
		rbin = new LinkedList<>();
		
		defColor = Color.blue;
		width = 4;
		
		setBackground(Color.yellow);
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		
		g2d.setStroke(new BasicStroke(width));

		for (LineV2 line : lines) {
			g2d.setColor(line.getColor());
			
			for (int i=1; i<line.size(); i++) {
				HashMap<String, Integer> p0 = line.getPoint(i-1);
				HashMap<String, Integer> p1 = line.getPoint(i);
				
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}
		
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size() > 0) {
			rbin.add(lines.removeLast());
			repaint();
		}
	}
	
	public void redo() {
		if (rbin.size() > 0) {
			lines.add(rbin.removeLast());
			repaint();
		}
	}
	
	public void changeColor(Color newColor) {
		defColor = newColor;
	}
	
	public Color getColor() {
		return defColor;
	}
	
	
	
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX()); point.put("y", e.getY());
			LineV2 line = new LineV2(defColor, 4);
			
			line.addPoint(point);;
			lines.add(line);
			rbin.clear();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX()); point.put("y", e.getY());
			
			lines.getLast().addPoint(point);;
			
			repaint();
		}
	}
	
	
	
	
}