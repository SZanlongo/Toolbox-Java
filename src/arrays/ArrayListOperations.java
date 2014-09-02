package arrays;

import java.util.ArrayList;

//http://users.cis.fiu.edu/~pestaina/ListOps.java
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ArrayListOperations {

	public static void insert(Comparable item, ArrayList<Comparable> list) {
		if (list.isEmpty() || item.compareTo(list.get(0)) <= 0) {
			list.add(0, item);
		} else {
			Comparable firstItem = list.remove(0);
			insert(item, list);
			list.add(0, firstItem);
		}
	}

	public static void insertionSort(ArrayList<Comparable> list) {
		if (list.size() > 1) {
			Comparable item = list.remove(0);
			insertionSort(list);
			insert(item, list);
		}
	}

	public static boolean linearScan(ArrayList<Comparable> list, Comparable item) {
		if (list.isEmpty()) {
			return false;
		}

		if (item.compareTo(list.get(0)) == 0) {
			return true;
		}

		Comparable firstItem = list.remove(0);
		boolean foundIt = linearScan(list, item);
		list.add(0, firstItem);
		return foundIt;
	}

	public static boolean binarySearch(ArrayList<Comparable> list,
			Comparable item) {
		return binarySearch(list, item, 0, list.size() - 1);
	}

	private static boolean binarySearch(ArrayList<Comparable> list,
			Comparable item, int loIndex, int hiIndex) {
		if (loIndex > hiIndex) {
			return false;
		}

		int middle = (loIndex + hiIndex) / 2;
		if (list.get(middle).compareTo(item) == 0) {
			return true;
		}

		if (list.get(middle).compareTo(item) < 0) {
			return binarySearch(list, item, middle + 1, hiIndex);
		}

		return binarySearch(list, item, loIndex, middle - 1);
	}

	public static ArrayList<Comparable> merge(ArrayList<Comparable> list1,
			ArrayList<Comparable> list2) {
		return merger(copy(list1), copy(list2));
	}

	private static ArrayList<Comparable> merger(ArrayList<Comparable> one,
			ArrayList<Comparable> two) {
		if (one.isEmpty()) {
			return two;
		}

		if (two.isEmpty()) {
			return one;
		}

		Comparable firstItem;

		int decider = one.get(0).compareTo(two.get(0));
		if (decider < 0) {
			firstItem = one.remove(0);
		} else {
			firstItem = two.remove(0);
			if (decider == 0) {
				one.remove(0);
			}
		}

		ArrayList<Comparable> combined = merge(one, two);
		combined.add(0, firstItem);
		return combined;
	}

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
}