package tw.org.iii.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.org.iii.apis.MyDrawer;

public class MySign extends JFrame {
	public MyDrawer myDrawer;
	
	public MySign() {
		super("My Sign");
	
		myDrawer = new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		
		setSize(800,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MySign();
	}

}
