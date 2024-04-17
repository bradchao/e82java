package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	private int counter;
	private int d = 5;
	
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
		
		
		input.setFont(new Font(null, Font.BOLD, 36));
		log.setFont(new Font(null, Font.BOLD + Font.ITALIC, 36));
		
		initEvent();
		
		initGame();
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initEvent() {
		//MyListener myListener = new MyListener(this);
		//guess.addActionListener(myListener);
		//guess.addActionListener(this);
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK3");
				guess();
			}
		});
		//guess.addActionListener(new ButtonListener());
	}
	
	private void guess() {
		counter++;
		String strInput = input.getText();
		String result = checkAB(strInput);
		log.append(String.format("%d. %s => %s\n", counter, strInput, result));
		input.setText("");
		
		if (result.equals(String.format("%dA0B",d))) {
			JOptionPane.showMessageDialog(null, "恭喜老爺");
			initGame();
		}else if (counter == 10) {
			JOptionPane.showMessageDialog(null, "魯蛇, 答案是:" + answer);
			initGame();
		}
		
	}
	
	private String checkAB(String strGuess) {
		int a, b; a = b = 0;
		for (int i=0; i<answer.length(); i++) {
			if (strGuess.charAt(i) == answer.charAt(i)) {
				a++;
			}else if (answer.indexOf(strGuess.charAt(i)) != -1) {
				b++;
			}
		}
		return String.format("%dA%dB", a, b);
	}
	
	
	
	private void initGame() {
		counter = 0;
		answer = createAnswer(d);
		log.setText("");
		//System.out.println(answer);
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

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("OK4");
		}
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



