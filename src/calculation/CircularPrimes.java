package calculation;

import java.util.ArrayList;

/*
 The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

 There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

 How many circular primes are there below one million?
 */

//https://github.com/jrivera777/ProjectEulerProblems
public class CircularPrimes {
	public static void main(String[] args) {
		int circularPrimes = 0;

		for (int i = 2; i <= 1000000; i++) {
			ArrayList<String> rots = getRotations(String.valueOf(i));
			boolean allPrime = true;
			for (String str : rots) {
				if (!LargestPrimeFactor.isPrimeInteger(Integer.parseInt(str))) {
					allPrime = false;
					break;
				}
			}
			if (allPrime) {
				circularPrimes++;
			}
		}
		System.out.println(circularPrimes);
	}

	private static ArrayList<String> getRotations(String str) {
		ArrayList<String> rots = new ArrayList<String>();

		String currentForm = str;

		for (int i = 0; i < str.length(); i++) {
			rots.add(currentForm);
			currentForm = currentForm.substring(1) + currentForm.substring(0, 1);
		}

		return rots;
	}
}
