package arrays;

import java.util.Hashtable;

public class FindMissingFromArray {

	/**
	 * @param args
	 */

	// Given two arrays, 1,2,3,4,5 and 2,3,1,0,5 find which number is not
	// present in the second array.
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 2, 3, 1, 0, 5 };

		System.out.println(missingNumber(arr1, arr2));
	}

	public static int missingNumber(int[] arr1, int[] arr2) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

		for (int i : arr1) {
			table.put(i, i);
		}

		for (int i : arr2) {
			if (!table.containsValue(i)) {
				return i;
			}
		}

		return -1;
	}

}
