package tw.org.iii.apis;

public class TWId {
	public static boolean checkTWId(String id) {
		// 1. length = 10
		// 2. 1 => A-Z
		// 3. 2 => 1 / 2
		// 4. 3 - 10 => 0-9
		boolean isRight = false;
		if (id.length() == 10) {
			char c1 = id.charAt(0);
//			if (c1 >= 65 && c1 <= 90) {
//				isRight = true;				
//			}
			String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			if (letters.indexOf(c1) != -1) {
				
			}
		}
		System.out.println(id.length());
		
		
		
		return isRight;
	}
}
