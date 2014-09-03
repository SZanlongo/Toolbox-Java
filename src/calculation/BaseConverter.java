package calculation;

import java.util.ArrayList;

//http://hawkee.com/snippet/9495/
public class BaseConverter {

	private int inBase;
	private int outBase;

	public BaseConverter(int iB, int oB) {
		inBase = iB;
		outBase = oB;
	}

	public int getInBase() {
		return inBase;
	}

	public int getOutBase() {
		return outBase;
	}

	public void setInBase(int iB) {
		inBase = iB;
	}

	public void setOutBase(int oB) {
		outBase = oB;
	}

	public String convert(String numString) {
		String answer = "";
		int[] numReversed = new int[numString.length()];
		int decimalValue = 0;
		int arrayIndex = 0;
		for (int currentCharIndex = numString.length() - 1; currentCharIndex >= 0; currentCharIndex--) {
			switch (numString.charAt(currentCharIndex)) {
			case 'a':
			case 'A':
				numReversed[arrayIndex] = ('A') - 55;
				break;
			case 'b':
			case 'B':
				numReversed[arrayIndex] = ('B') - 55;
				break;
			case 'c':
			case 'C':
				numReversed[arrayIndex] = ('C') - 55;
				break;
			case 'd':
			case 'D':
				numReversed[arrayIndex] = ('D') - 55;
				break;
			case 'e':
			case 'E':
				numReversed[arrayIndex] = ('E') - 55;
				break;
			case 'f':
			case 'F':
				numReversed[arrayIndex] = ('F') - 55;
				break;
			default:
				numReversed[arrayIndex] = Integer.parseInt(Character.toString(numString
						.charAt(currentCharIndex)));
			}
			if (numReversed[arrayIndex] > inBase - 1) {
				return numString + " is not a valid base-" + inBase + " number.";
			}
			numReversed[arrayIndex] *= Math.pow(inBase, arrayIndex);
			arrayIndex++;
		}
		for (int element : numReversed) {
			decimalValue += element;
		}
		if (outBase == 10) {
			return Integer.toString(decimalValue);
		}
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while (decimalValue != 0) {
			nums.add(decimalValue % outBase);
			decimalValue /= outBase;
		}
		for (int currentArrayIndex = nums.size() - 1; currentArrayIndex >= 0; currentArrayIndex--) {
			if (nums.get(currentArrayIndex) >= 10) {
				answer += Character.toString((char) (nums.get(currentArrayIndex) + 55));
				continue;
			}
			answer += Integer.toString(nums.get(currentArrayIndex));
		}
		return answer;
	}

}