package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.apis.MyDrawer;
import tw.org.iii.apis.MyDrawerV2;

public class MySign extends JFrame {
	public MyDrawerV2 myDrawer;
	private JButton clear, undo, redo, color, width;
	
	public MySign() {
		super("My Sign");
	
		myDrawer = new MyDrawerV2();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo); top.add(color);
		add(top, BorderLayout.NORTH);
		
		setSize(800,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addEnents();
	}
	
	private void addEnents() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, "Change Line Color", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.changeColor(newColor);
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
