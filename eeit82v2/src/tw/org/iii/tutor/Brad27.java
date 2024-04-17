package tw.org.iii.tutor;

public class Brad27 {
	public static void main(String[] args) {
		Brad271 obj1 = new Brad271() {
			public void m3() {
				System.out.println("Brad271:m3()");
			}
		};
		obj1.m1();
		obj1.m2();
		obj1.m3();
		Brad272 obj2 = new Brad272() {
			void m4() {System.out.println("Brad272:m4()");}
		};
		obj2.m4();
	}
}
abstract class Brad271 {
	void m1() {System.out.println("Brad271:m1()");}
	void m2() {System.out.println("Brad271:m2()");}
	abstract void m3();
}
class Brad272 {
	void m4() {}
	void m5() {}
}
