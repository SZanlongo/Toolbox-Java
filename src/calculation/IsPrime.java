package calculation;

public class IsPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(prime(6));
	}

	public static boolean prime(int num) {
		for (int i = 2; i < num; i++) {
			if ((num % i) == 0) {
				return false;
			}
		}

		return true;

	}

}
