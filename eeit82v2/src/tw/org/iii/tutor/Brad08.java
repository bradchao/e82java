package tw.org.iii.tutor;

public class Brad08 {

	public static void main(String[] args) {
		int month = 11;
		switch(month) {
			case 1, 3, 5, 7,8,10,12:
				// 31
				break;
			case 4, 6, 9, 11:
				// 30
				break;
			case 2:
				// 28 or 29
				break;
			default:
				System.out.println("X");
		}
		System.exit(0);

	}

}
