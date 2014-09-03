package calculation;

import java.util.Calendar;
import java.util.Date;

/*
 You are given the following information, but you may prefer to do some research for yourself.
 1 Jan 1900 was a Monday.
 Thirty days has September,
 April, June and November.
 All the rest have thirty-one,
 Saving February alone,
 Which has twenty-eight, rain or shine.
 And on leap years, twenty-nine.
 A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class CountingSundays {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(1901, 0, 1);
		System.out.println(cal.getTime());
		int sundays = 0;
		Date d = null;
		do {
			d = cal.getTime();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				sundays++;
				// System.out.println(d);
			}
			cal.add(Calendar.MONTH, 1);
			System.out.println(d);
		} while (cal.get(Calendar.YEAR) < 2001);

		System.out.println(sundays);
	}
}
