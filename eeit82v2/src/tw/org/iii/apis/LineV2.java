package tw.org.iii.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class LineV2 implements Serializable {
	private LinkedList<HashMap<String,Integer>> line;
	private Color color;
	private int width;
	
	public LineV2(Color color, int width) {
		this.color = color;
		this.width = width;
		line = new LinkedList<>();
	}
	
	public void addPoint(HashMap<String,Integer> point) {
		line.add(point);
	}
	public HashMap<String,Integer> getPoint(int index) {
		return line.get(index);
	}
	public Color getColor() {return color;}
	public int getWidth() {return width;}
	public int size() {return line.size();}
}
