package calculation;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(10));
	}

	// return Fibonacci series
	/*
	 * Fibonacci number is sum of previous two Fibonacci numbers fn = fn-1+ fn-2
	 * First 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
	 */
	/*
	 * highestOrCount = h if input is the highest number the series should
	 * proceed to highestOrCount = c if input is the number of times to run num
	 * = input number for either of the two choices
	 */

	public static int fib(int count) {
		if (count == 1 || count == 2) {
			return 1;
		} else {
			int fib = fib(count - 2) + fib(count - 1);
			return fib;
		}
	}

}
