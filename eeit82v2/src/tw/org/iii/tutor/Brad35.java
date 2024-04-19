package tw.org.iii.tutor;

public class Brad35 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		int[] c = new int[3];
		System.out.println("Brad");
		try {
			System.out.println(a / b);
			System.out.println(c[3]);
			System.out.println("iSpan");
		}catch (ArithmeticException e) {
			System.out.println("Ooop!1");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ooop!2");
		}
		System.out.println("OK");
	}

}
