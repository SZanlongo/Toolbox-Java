package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindDuplicates {

	/**
	 * @param args
	 */

	// In an array 1-100 many numbers are duplicates, how do you find it?
	public static void main(String[] args) {
		int[] arr = new int[100];

		for (int i = 0; i < 100; i++) {
			arr[i] = i;
		}

		arr[10] = 14;
		arr[35] = 99;
		arr[97] = 14;

		System.out.println(Arrays.toString(arr));

		Set<Integer> sortedSet = new TreeSet<Integer>(findDuplicates(arr));

		for (int i : sortedSet) {
			System.out.println(i);
		}

	}

	public static Set<Integer> findDuplicates(int[] a) {
		Set<Integer> temp = new HashSet<Integer>();
		Set<Integer> dups = new HashSet<Integer>();

		for (int i : a) {
			if (!temp.add(i)) {
				dups.add(i);
			}
		}

		return dups;
	}

}
