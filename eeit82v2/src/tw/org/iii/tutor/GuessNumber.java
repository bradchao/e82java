package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		
		initEvent();
		
		initGame();
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initEvent() {
		MyListener myListener = new MyListener(this);
		guess.addActionListener(myListener);
		guess.addActionListener(this);
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK3");
			}
		});
	}
	
	private void initGame() {
		answer = createAnswer(4);
		System.out.println(answer);
	}
	
	private String createAnswer(int d) {
		int num = 10;
		int[] poker = new int[num];
		for (int i = 0; i<num; i++) poker[i] = i;
		
		for (int i = num - 1; i > 0 ; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}	
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i< d; i++) {
			sb.append(poker[i]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK2");
		
		
	}

}

class MyListener implements ActionListener {
	private GuessNumber guessNumber;
	
	public MyListener(GuessNumber guessNumber) {
		this.guessNumber = guessNumber;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK1");
	
	}
}



