package tw.org.iii.tutor;

public class Brad99 {

	public static void main(String[] args) {
		final int ROW = 1;
		final int COL = 9;
		final int START = 1;
		
		for (int z = 0; z < ROW; z++) {
			for (int y = 1 ; y <= 9; y++) {
				for (int x = START; x <= START + COL - 1; x++) {
					int newX = x + z * COL;
					int r = newX * y;
					System.out.printf("%d x %d = %d\t", newX, y, r);
				}
				System.out.println();
			}
			System.out.println("---");
		}
		

	}

}
