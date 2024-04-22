package tw.org.iii.tutor;

import java.awt.FontFormatException;

import javax.management.RuntimeErrorException;

public class Brad39 {
	public static void main(String[] args) {
		try {
			m3();
		} catch (Exception e) {
		}
		m4(-3);
	}
	static void m1() throws Exception{
		throw new Exception();
	}
	static void m2() throws Exception {
		m1();
	}
	static void m3() throws Exception {
		m2();
	}
	
	static int m4(int a) {
		System.out.println("m4()");
		
		try {
			if (a > 0 ) {
				System.out.println("OK");
			}else {
				m1();
				System.out.println("debug1");
			}
			System.out.println("debug2");
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}finally {
			System.out.println("finally");
		}
		
		System.out.println("before return");
		return a;
	}
	
	
}
class Brad391 {
	void m1() throws Exception {}
	void m1(int a) {}
}
class Brad392 extends Brad391 {
	void m1() throws FontFormatException {}
}
class Brad393 extends Brad392{
	void m1() {}
}
