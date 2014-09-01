package arrays;

public class DynamicArray {

	public static void main(String[] args) {
		new DynamicArray();
	}

	public DynamicArray() {
		String[][] a = { { "This", "is", "an", "array" }, { "A", "two", "dimensional", "array" } };
		String[] b = { "This", "is", "an", "array" };

		// Shrink subtracts 1 index
		System.out.println(b.length + " Pre-Shrink length");
		b = shrink(b, 1);
		System.out.println(b.length + " Post-Shrink length\r\n");

		// Two-Dimensional Array Shrink subtracts 1 row and 1 column
		System.out.println(a.length + " " + a[0].length
				+ " Pre-Shrink Array Rows/Columns values (2D)");
		a = shrink(a, 1, 1);
		System.out.println(a.length + " " + a[0].length
				+ " Post-Shrink Array Rows/Columns values (2D)\r\n");

		// Expand adds 1 index
		System.out.println(b.length + " Pre-Expansion length");
		b = expand(b, 1);
		System.out.println(b.length + " Post-Expansion length\r\n");

		// Two-Dimensional Array Expand adds 1 row and 1 column
		System.out.println(a.length + " " + a[0].length
				+ " Pre-Expansion Rows/Columns lengths (2D)");
		a = expand(a, 1, 1);
		System.out.println(a.length + " " + a[0].length
				+ " Post-Expansion Rows/Columns lengths (2D)\r\n");
	}

	public String[] shrink(String[] s, int amt) {
		if (amt >= s.length) {
			return s;
		} else {
			String[] out = new String[(s.length - amt)];
			for (int i = 0; i < out.length; i++) {
				out[i] = s[i];
			}
			return out;
		}
	}

	public String[][] shrink(String[][] s, int rows, int col) {
		if (rows >= s.length || col >= s[0].length) {
			return s;
		} else {
			String[][] out = new String[(s.length - rows)][(s[0].length - col)];
			for (int i = 0; i < out.length; i++) {
				for (int a = 0; a < out[i].length; a++) {
					out[i][a] = s[i][a];
				}
			}
			return out;
		}
	}

	public String[] expand(String[] s, int amt) {
		String[] out = new String[(s.length + amt)];
		for (int i = 0; i < out.length; i++) {
			try {
				out[i] = s[i];
			} catch (Exception e) {
				out[i] = "";
			}
		}
		return out;
	}

	public String[][] expand(String[][] s, int rows, int col) {
		String[][] out = new String[(s.length + rows)][(s[0].length + col)];
		for (int i = 0; i < out.length; i++) {
			for (int a = 0; a < out[i].length; a++) {
				try {
					out[i][a] = s[i][a];
				} catch (Exception e) {
					out[i][a] = "";
				}
			}
		}
		return out;
	}
}