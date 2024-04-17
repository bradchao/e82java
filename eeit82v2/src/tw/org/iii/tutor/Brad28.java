package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.Iterator;

import tw.org.iii.apis.Bike;

public class Brad28 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("Brad");
		set.add("Brad");
		set.add(new String("Brad"));
		set.add(12);	// auto-boxing int = > Integer
		set.add(12.3);	// double => Double
		System.out.println(set.size());
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof String) {
				System.out.println("String:" + obj);
			}else if (obj instanceof Integer) {
				System.out.println("Integer: " + obj);
			}else if (obj instanceof Double) {
				System.out.println("Double: " + obj);
			}else {
				System.out.println("XX");
			}
		}
		System.out.println(set);
		System.out.println("---");
		for (Object obj : set) {
			if (obj instanceof String) {
				System.out.println("String:" + obj);
			}else if (obj instanceof Integer) {
				System.out.println("Integer: " + obj);
			}else if (obj instanceof Double) {
				System.out.println("Double: " + obj);
			}else {
				System.out.println("XX");
			}
		}
		
		
		
		
		
	}


}
