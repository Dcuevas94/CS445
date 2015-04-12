import java.util.Random;

public class ImprovedRandom extends Random {
	
	public static int randIntParameter(int min, int max) {
		Random randomInt = new Random();
		int ranNum = randomInt.nextInt((max - min) + 1 ) + min;
		return ranNum;
	}

}
