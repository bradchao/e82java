package tw.org.iii.apis;

public class TWId {
	private String id;
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
//	public TWId(String id) {
//		this.id = id;
//	}
	
	public TWId() {
		this((int)(Math.random()*2) == 0);
	}
	public TWId(boolean isMale) {
		this(isMale, (int)(Math.random()*26));
	}
	public TWId(int area) {
		this((int)(Math.random()*2) == 0, area);
	}
	
	public TWId(boolean isMale, int area) {	// area = 0 ~25
		StringBuffer sb = new StringBuffer();
		sb.append(letters.substring(area, area+1))
			.append(isMale ? "1" : "2")
			.append((int)(Math.random()*10))
			.append((int)(Math.random()*10))
			.append((int)(Math.random()*10))
			.append((int)(Math.random()*10))
			.append((int)(Math.random()*10))
			.append((int)(Math.random()*10))
			.append((int)(Math.random()*10));
		String temp = sb.toString();
		for (int i=0; i<10; i++) {
			if (checkTWId(temp + i)) {
				id = temp + i;
				break;
			}
		}

	}
	
	
	@Override
	public String toString() {
		return String.format("ID = %s", id);
	}
	
	
	public static boolean checkTWId(String id) {
		// 1. length = 10
		// 2. 1 => A-Z
		// 3. 2 => 1 / 2
		// 4. 3 - 10 => 0-9
		boolean isRight = false;
		if (id.matches("[A-Z][12][0-9]{8}")) {
			char c1 = id.charAt(0);
			int a12 = letters.indexOf(c1) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			int n1 = Integer.parseInt(id.substring(1, 2)) ;
			int n2 = Integer.parseInt(id.substring(2, 3)) ;
			int n3 = Integer.parseInt(id.substring(3, 4)) ;
			int n4 = Integer.parseInt(id.substring(4, 5)) ;
			int n5 = Integer.parseInt(id.substring(5, 6)) ;
			int n6 = Integer.parseInt(id.substring(6, 7)) ;
			int n7 = Integer.parseInt(id.substring(7, 8)) ;
			int n8 = Integer.parseInt(id.substring(8, 9)) ;
			int n9 = Integer.parseInt(id.substring(9, 10)) ;
			int n = a1*1 + a2*9 + n1*8 + n2 *7 + n3*6 + n4*5 + n5*4 + n6*3 + 
					n7*2 + n8*1 + n9*1;
			
			isRight = n % 10 == 0;
		}
		
		
		
		return isRight;
	}
}
