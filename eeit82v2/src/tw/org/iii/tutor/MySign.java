package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.org.iii.apis.MyDrawerV2;

public class MySign extends JFrame {
	public MyDrawerV2 myDrawer;
	private JButton clear, undo, redo, color, width, saveJPEG,
		saveLines, loadLines;
	
	public MySign() {
		super("My Sign");
	
		myDrawer = new MyDrawerV2();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		saveJPEG = new JButton("Save JPEG");
		saveLines = new JButton("Save Lines");
		loadLines = new JButton("Load Lines");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo); top.add(color);
		top.add(saveJPEG); top.add(saveLines); top.add(loadLines);
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
		saveJPEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.saveJPEG();
					JOptionPane.showMessageDialog(null, "Save JPEG success");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Save JPEG failure");
				}
			}
		});
		
		saveLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveLines();
			}
		});
		loadLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadLines();
			}
		});
	}
	
	private void saveLines() {
		JFileChooser jfc = new JFileChooser();
		if ( jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = jfc.getSelectedFile();
			try {
				myDrawer.saveLine(selectedFile);
				JOptionPane.showMessageDialog(null, "Save Success");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Save Failure");
			}
		}
	}
	
	private void loadLines() {
		JFileChooser jfc = new JFileChooser();
		if ( jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = jfc.getSelectedFile();
			try {
				myDrawer.loadLine(selectedFile);
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Load Failure");
			}
		}		
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
