package calculation;

import java.math.BigInteger;

/*
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 21000?
 */

public class PowerDigitSum {
	public static final BigInteger TWO = new BigInteger("2");

	public static void main(String[] args) {
		BigInteger val = BigInteger.ONE;
		int sum = 0;

		val = TWO.pow(1000);

		char[] chars = val.toString().toCharArray();

		for (char c : chars) {
			sum += Integer.parseInt(String.valueOf(c));
		}
		System.out.println(sum);
	}
}
