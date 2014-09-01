package arrays;

import java.util.Random;
import java.util.ArrayList;

public class ArrayListOperationsClient {

	public static void main(String[] args) {
		Random gen = new Random();

		ArrayList<Comparable> listOne = new ArrayList<Comparable>();

		for (int k = 1; k <= 17; k++) {
			int number = gen.nextInt(90) + 10;
			if (!ArrayListOperations.binarySearch(listOne, number)) {
				ArrayListOperations.insert(number, listOne);
			}
		}
		System.out.println("ONE: " + listOne);

		ArrayList<Comparable> listTwo = new ArrayList<Comparable>();
		for (int k = 1; k <= 17; k++) {
			int number = gen.nextInt(90) + 10;
			if (!ArrayListOperations.linearScan(listTwo, number)) {
				listTwo.add(number);
			}
		}
		System.out.println("TWO: " + listTwo);

		ArrayListOperations.insertionSort(listTwo);
		System.out.println("TWO: " + listTwo);

		ArrayList<Comparable> both = ArrayListOperations.merge(listOne, listTwo);
		System.out.println("ALL: " + both);
	}
}