package tw.org.iii.tutor;

public class Brad09 {

	public static void main(String[] args) {
		int a = 0;
		
		for (printBrad(); a < 10; printLine()){
			System.out.println(a++);
		}
		
		//System.out.println("-----");
		System.out.println(a);
	}

	static void printBrad() {
		System.out.println("Brad");
	}
	static void printLine() {
		System.out.println("-----");
	}
}
