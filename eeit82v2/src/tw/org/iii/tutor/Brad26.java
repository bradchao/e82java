package tw.org.iii.tutor;
public class Brad26 {
	public static void main(String[] args) {
		Brad263 obj1 = new Brad263();
		Brad261 obj2 = new Brad263();
		Brad262 obj3 = new Brad263();
		
	}
}
interface Brad261 {
	void m1();
	void m2();
}
interface Brad262 {
	void m3();
	void m4();
}
class Brad263 extends Object implements Brad261, Brad262 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
interface Brad264 extends Brad261, Brad262{
	void m5();
}
class Brad265 implements Brad264 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
	public void m5() {}
	
}




