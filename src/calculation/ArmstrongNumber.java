package calculation;

public class ArmstrongNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(armstrong(153));
	}

	public static boolean armstrong(int num) {
		int result = 0;
		int orig = num;
		while (num != 0) {
			int remainder = num % 10;
			result = result + remainder * remainder * remainder;
			num = num / 10;
		}

		if (orig == result) {
			return true;
		} else
			return false;
	}
}
