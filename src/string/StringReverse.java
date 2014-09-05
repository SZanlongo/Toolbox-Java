package string;

public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Original");
		System.out.println(reverse("Original"));
	}

	public static String reverse(String original) {
		String reverse = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse += original.charAt(i);
		}

		return reverse;

	}

}
