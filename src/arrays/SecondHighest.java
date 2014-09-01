package arrays;

public class SecondHighest {

	/**
	 * @param args
	 */
	// How do you find second highest number in an integer array?
	public static void main(String[] args) {
		int[] arr = { 1, 8, 2, 5, 7 };

		System.out.println(secondHighest(arr));
	}

	// assume array is > 2
	public static int secondHighest(int[] arr) {
		int secondHighest;
		int highest;

		if (arr[0] < arr[1]) {
			secondHighest = arr[0];
			highest = arr[1];
		} else {
			secondHighest = arr[1];
			highest = arr[0];
		}

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > secondHighest && arr[i] < highest) {
				secondHighest = arr[i];
			} else if (arr[i] > highest) {
				secondHighest = highest;
				highest = arr[i];
			}
		}

		return secondHighest;
	}

}
