package tw.org.iii.tutor;

import java.util.HashMap;
import java.util.Set;

public class Brad32 {

	public static void main(String[] args) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", "Brad");
		map.put("age", 18);
		map.put("weight", 78.5);
		map.put("age", 38);
		System.out.println(map.get("age"));
		Set<Object> keys = map.keySet();
		for (Object key : keys) {
			System.out.println(key + ":" + map.get(key));
		}
	}

}
