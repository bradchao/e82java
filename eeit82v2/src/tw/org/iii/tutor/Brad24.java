package tw.org.iii.tutor;
public class Brad24 {
	public static void main(String[] args) {
		Brad242 obj = new Brad242();
		obj.m1();

	}
}
class Brad241 {
	void m1() {System.out.println("Brad241:m1()");}
	private String m1(int a) {
		System.out.println("Brad241:m1(int)");
		return null;
	}
}
class Brad242 extends Brad241 {
	void m1() {
		super.m1();
		System.out.println("Brad242:m1()");
	}
	void m2() {
		super.m1();
		this.m1();
	}
	public StringBuffer m1(int a) {
		System.out.println("Brad242:m1(int)"); 
		return null;
	}
}
class Brad243 extends Brad242 {
	void m1() {
		super.m1();
	}
}
