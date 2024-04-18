package tw.org.iii.apis;

import java.awt.Color;
import java.util.LinkedList;

public class Line {
	private LinkedList<Point> line;
	private Color color;
	private double width;
	public Line(Color color, double width) {
		this.color = color;
		this.width = width;
		line = new LinkedList<>();
	}
	
	public void addPoint(Point point) {
		line.add(point);
	}
	public Point getPoint(int index) {
		return line.get(index);
	}
	public Color getColor() {return color;}
	public double getWidth() {return width;}
	public int size() {return line.size();}
}
