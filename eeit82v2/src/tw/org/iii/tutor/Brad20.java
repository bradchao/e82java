package tw.org.iii.tutor;

import tw.org.iii.apis.TWId;

public class Brad20 {

	public static void main(String[] args) {
		if (TWId.checkTWId("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		System.out.println(new TWId());
		System.out.println(new TWId(true));
		System.out.println(new TWId(4));
		System.out.println(new TWId(false, 7));
		
		TWId myId = TWId.createTWId("Y120239847");
		if (myId != null) {
			System.out.println(myId);
		}else {
			System.out.println("XX");
		}
		
		

	}

}
