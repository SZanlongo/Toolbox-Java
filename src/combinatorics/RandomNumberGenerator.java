package combinatorics;

public class RandomNumberGenerator {

	public void randomNumberGenerator() {
		int randomValue = 0;

		for (int i = 0; i < 10; i++) {
			randomValue = (int) (Math.random() * 10);

			System.out.println("Random No " + i + ". " + randomValue);
		}
	}
}
