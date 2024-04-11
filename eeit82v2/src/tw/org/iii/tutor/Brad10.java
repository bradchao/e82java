package tw.org.iii.tutor;

public class Brad10 {

	public static void main(String[] args) {
		int[] ary = new int[3];
		System.out.println(ary.length);
		ary[0] = 123; ary[2] = 12;
		for (int i=0; i<ary.length; i++) {
			System.out.println(ary[i]);
		}
		System.out.println("---");
		for(int v : ary) {
			System.out.println(v);
		}

	}

}
