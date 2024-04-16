package tw.org.iii.tutor;
public class Brad22 {
	public static void main(String[] args) {
		Brad224 obj1 = new Brad224();
		obj1.m1();
		Brad221 obj2 = new Brad221();
		Brad221 obj3 = new Brad222();
		Brad221 obj4 = new Brad224();
		obj4.m1();
		Brad224 obj5 = (Brad224)obj2;
		obj5.m4();
		//Brad223 obj6 = (Brad223)obj4;
		
		ma(obj1);
	}
	
	static void ma(Brad221 obj) {
		obj.m1();
		if (obj instanceof Brad224) {
			((Brad224)obj).m4();
		}else if (obj instanceof Brad222) {
			((Brad222)obj).m2();
		}
	}
}

class Brad221 {
	Brad221(){System.out.println("Brad221");}
	void m1() {System.out.println("Brad221:m1()");}
}
class Brad222 extends Brad221 {
	Brad222(){System.out.println("Brad222");}
	void m1() {System.out.println("Brad222:m1()");}
	void m2() {System.out.println("Brad222:m2()");}
}
class Brad223 extends Brad221 {
	Brad223(){System.out.println("Brad223");}
	void m1() {System.out.println("Brad223:m1()");}
	void m3() {System.out.println("Brad223:m3()");}
}
class Brad224 extends Brad222 {
	Brad224(){System.out.println("Brad224");}
	void m1() {System.out.println("Brad224:m1()");}
	void m4() {System.out.println("Brad224:m4()");}
}
