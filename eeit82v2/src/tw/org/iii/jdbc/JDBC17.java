package tw.org.iii.jdbc;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.org.iii.apis.MyTable;

public class JDBC17 extends JFrame {
	private MyTable myTable;
	
	public JDBC17() {
		
		setLayout(new BorderLayout());
		myTable = new MyTable();
		add(myTable, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JDBC17();
	}

}
