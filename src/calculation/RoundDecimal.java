package calculation;

import java.math.BigDecimal;

//https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
public class RoundDecimal {
	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
}
