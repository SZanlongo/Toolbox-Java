package arrays;

import java.util.ArrayList;
import java.util.Random;

//https://users.cs.fiu.edu/~pestaina/SimpleSort.java
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BubbleSort {
	public static void main(String[] args) {

		ArrayList<Comparable> two = randomIntegerList(19);
		System.out.println("TWO: " + two);
		bubbleSort(two);
		// System.out.println("TWO: " + two);
		System.out.println();
	}

	public static void bubbleSort(ArrayList<Comparable> list) {
		if (list.size() > 1) {
			// Bubble the largest element into the last position
			bubble(list);

			// Remove the last (largest) element
			Comparable<?> last = list.remove(list.size() - 1);

			// Recursively, sort the shortened list
			bubbleSort(list);

			// Replace the (largest) last element
			list.add(last);
		}
	}

	// One pass of bubble-sort puts the BIGGEST element at the far end
	// Recursively,
	// if element-0 > element-1, swap them (that's the bubble!)
	// repeat with the shortened list obtained by removing element-0
	private static void bubble(ArrayList<Comparable> list) {
		if (list.size() > 1) {
			if (list.get(0).compareTo(list.get(1)) > 0) {
				// Swap the 1st & 2nd elements so that list.get(0) <=
				// list.get(1)
				Comparable temp = list.remove(0);
				list.add(1, temp);
			}
			// Shorten the list by removing the 1st element
			Comparable first = list.remove(0);

			// Recursive call on the shorter list
			bubble(list);

			// Replace the 1st element
			list.add(0, first);
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
