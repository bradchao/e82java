package tw.org.iii.tutor;

import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		int num = 52;
		int[] poker = new int[num];
		for (int i = 0; i<num; i++) poker[i] = i;
		
		for (int i = num - 1; i > 0 ; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}

//		for (int card : poker) {
//			System.out.println(card);
//		}
//		System.out.println("---");
		
		int[][] players = new int[4][13];
		for (int i=0; i<num; i++) {
			players[i%4][i/4] = poker[i];
		}
		
		String[] suits = {"黑桃","紅心","梅花","方塊"};
		String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ",
				"8 ","9 ","10","J ","Q ","K "};
		for (int[] player : players) {
			Arrays.sort(player);
			for (int card : player) {
				System.out.printf("%s%s  ", suits[card/13], values[card%13]);
			}
			System.out.println();
		}
		
	}

}
