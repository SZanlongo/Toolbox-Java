package arrays;

import java.util.ArrayList;
import java.util.Random;

public class SelectionSort {
	public static void main(String[] args) {
		ArrayList<Comparable> one = randomIntegerList(19);
		System.out.println("ONE: " + one);
		selectionSort(one);
		// System.out.println("ONE: " + one);
		System.out.println();
	}

	public static void selectionSort(ArrayList<Comparable> list) {
		if (list.size() > 1) {
			// Remove the smallest element
			Comparable smallest = selectMin(list);

			// Sort the remaining elements
			selectionSort(list);

			// Put the smallest element up front
			list.add(0, smallest);
		}
	}

	// Helper method to remove the smallest element from a list
	// The elements are assumed to be in random order
	// Method may not preserve the order of the other elements
	private static Comparable selectMin(ArrayList<Comparable> list) {
		// If there's only one, it's the smallest!
		if (list.size() == 1) {
			return list.remove(0);
		}

		Comparable firstItem = list.remove(0); // Select the first element
		Comparable smallItem = selectMin(list);// Select the smallest of the
												// rest

		// Choose the smaller to these 2 elements
		// remembering to replace the other one
		if (firstItem.compareTo(smallItem) < 0) {
			list.add(smallItem);
			return firstItem;
		} else {
			list.add(firstItem);
			return smallItem;
		}
	}

	public static ArrayList<Comparable> randomIntegerList(int size) {
		Random gen = new Random();

		ArrayList<Comparable> list = new ArrayList<Comparable>();
		int count = 0;
		while (count < size) {
			int number = gen.nextInt(90) + 10; // random 2-digit number
			if (!list.contains(number)) // no duplicates allowed
			{
				list.add(number);
				count++;
			}
		}
		return list;
	}
}
