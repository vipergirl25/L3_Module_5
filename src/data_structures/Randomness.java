package data_structures;

import java.util.Random;

public class Randomness {
	Randomness() {
		
	}
	public static boolean randomtruefalse() {
		int number = new Random().nextInt(2);
		if(number==1) {
			return false;
			
		}else {
			return true;
			
		}
	}
	public static int randomnumber() {
		int random = new Random().nextInt(11);
		return random;
	}
}
