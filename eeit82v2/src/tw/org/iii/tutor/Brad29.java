package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad29 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery = new TreeSet<>();
		while (lottery.size() < 6) {
			lottery.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery);
	}

}
