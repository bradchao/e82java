package tw.org.iii.tutor;

import tw.org.iii.apis.Bike;

public class Brad19 {

	public static void main(String[] args) {
		String s1 = "brad";
		String s2 = "brad";
		System.out.println(s1 == s2);
		String s3 = new String("brad");
		String s4 = new String("brad");
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s3));
		
		Bike b1 = new Bike();
		System.out.println(b1);
		System.out.println(s1);
		
		System.out.println("iSpan".charAt(0));
		String s5 = s1.concat("Hello");
		System.out.println(s5);
		System.out.println(s1);
		String s6 = s1 + s2;
		s2.concat("OK");
		System.out.println(s2);
		
		
		
		
		
		
		

	}

}
