package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@SuppressWarnings("serial")
public class CustomList extends ArrayList<Integer> {

	// SOLUTION 1
	/**
	 * This solution is an insert sort. It's useful when you're constantly
	 * refreshing information. It's good in that situation because when you
	 * refresh you iterate through the list, if the list is already sorted then
	 * you save processing time
	 */
	@Override
	public boolean add(Integer object) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) > object) {
				this.add(i, object);
				return true;
			}
		}

		if (this.size() == 0) {
			this.add(0, object);
		}

		return true;
	}

	// SOLUTION 2
	/**
	 * This solution uses the sort algorithm that java decides to use. Java has
	 * an algorithm where it chooses the best type of sort to use. This solution
	 * is best if you're inserting objects very rapidly but are only displaying
	 * them every now and then
	 */
	@Override
	public Iterator<Integer> iterator() {
		Collections.sort(this);
		return super.iterator();
	}
}
