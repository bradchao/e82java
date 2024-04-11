package tw.org.iii.tutor;

public class Brad12 {

	public static void main(String[] args) {
		int[] p = new int[6];	// [0] = 0 ... [5] = 0
		int point = 0;
		
		for (int i=0; i< 1000000; i++) {
			point = (int)(Math.random()*9) + 1;		// 1 ~ 9
			p[point<7?point-1:point-4]++;
		}
		
		for (int i = 0; i<p.length; i++) {
			System.out.printf("%d點出現%d次\n", i+1, p[i]);
		}
		
		//System.out.println(p[10000]);
		
		

	}

}
