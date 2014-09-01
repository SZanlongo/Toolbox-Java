package arrays;

import java.util.ArrayList;
import java.util.Random;

public class FindIntersection {
	public static void main(String[] args) {

		ArrayList<Comparable> one = randomIntegerList(19);
		System.out.println("ONE: " + one);
		SelectionSort.selectionSort(one);
		// System.out.println("ONE: " + one);
		System.out.println();

		ArrayList<Comparable> two = randomIntegerList(19);
		System.out.println("TWO: " + two);
		BubbleSort.bubbleSort(two);
		// System.out.println("TWO: " + two);
		System.out.println();

		System.out.println("ONE: " + one);
		System.out.println("TWO: " + two);
		System.out.println("INTERSECTION: " + FindIntersection.intersection(one, two));
		System.out.println();
	}

	// Finds the elements common to 2 sorted lists.
	public static ArrayList<Comparable> intersection(ArrayList<Comparable> list1,
			ArrayList<Comparable> list2) {
		return commonElements(copy(list1), copy(list2));
	}

	// Helper works with copies, so that it can "cannibalize" its lists
	private static ArrayList<Comparable> commonElements(ArrayList<Comparable> list1,
			ArrayList<Comparable> list2) {
		ArrayList<Comparable> common = new ArrayList<Comparable>();

		if (list1.isEmpty() || list2.isEmpty()) {
			return common; // Empty
		}
		Comparable duplicate = null;

		int decisionKey = list1.get(0).compareTo(list2.get(0));
		if (decisionKey < 0) {
			list1.remove(0);
		} else if (decisionKey > 0) {
			list2.remove(0);
		} else {
			duplicate = list1.remove(0);
			list2.remove(0);
		}

		common = commonElements(list1, list2);
		if (duplicate != null) {
			common.add(0, duplicate);
		}

		return common;
	}

	// Make a copy of a list
	private static ArrayList<Comparable> copy(ArrayList<Comparable> source) {
		ArrayList<Comparable> image = new ArrayList<Comparable>();

		if (source.isEmpty()) {
			return image;
		}

		Comparable firstItem = source.remove(0);
		image = copy(source);
		source.add(0, firstItem);
		image.add(0, firstItem);

		return image;
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
