package arrays;

import java.util.ArrayList;
//An instance of this class is a list that maintains its elements
//	in ascending order as determined by the compareTo() method of
//	the class to which the elements belong.

public class OrderedList {

	private ArrayList<Comparable> store;

	// Constructor creates an empty list
	public OrderedList() {
		this.store = new ArrayList<Comparable>();
	}

	// Returns a count of the number of stored items
	public int size() {
		return this.store.size();
	}

	// Adds an item to the list, maintaining ascending order
	// The list is permitted to contain duplicated elements
	public void insert(Comparable item) {
		// Scan the list until either
		// a) scanned through the entire list, or
		// b) a BIGGER or EQUAL element is located
		int index = 0;
		while (index < this.store.size() && item.compareTo(this.store.get(index)) > 0) {
			index++;
		}

		// Current index value defines the position for the inserted item
		this.store.add(index, item);
	}

	// Removes from the list an element matching the parameter
	// The list is unchanged if there is no matching element
	public void remove(Comparable item) {
		// Simplest to code, but may not be quickest
		// this.store.remove(item);

		// To exploit the known ordering of the items in the store,
		// scan until a BIGGER or EQUAL element is encountered
		int index = 0;
		while (index < this.store.size() && item.compareTo(this.store.get(index)) > 0) {
			index++;
		}

		// If the scan stopped because an EQUAL element is located, remove it
		// otherwise (stopped on finding a BIGGER element) nothing to remove
		if (index < this.store.size() && item.compareTo(this.store.get(index)) == 0) {
			this.store.remove(index);
		}
	}

	// Implements the BINARY SEARCH technique to determine if
	// an element of the list matches the parameter item
	public boolean contains(Comparable item) {
		// lo & hi index variables "bracket" the current search range
		int lo = 0;
		int hi = this.store.size() - 1;

		// Search fails when the search range
		// becomes "inverted", i.e, lo > hi
		while (lo <= hi) {
			// Find the mid-point of the current search range
			// And determine it that element matches the item
			int mid = (lo + hi) / 2;
			int key = this.store.get(mid).compareTo(item);

			if (key == 0) // middle-element == item
			{
				return true; // terminate with SUCCESS
			}
			if (key < 0) // middle-element < item
			{
				lo = mid + 1; // reset range to "upper" half
			} else // middle-element > item
			{
				hi = mid - 1; // reset range to "lower" half
			}
		}
		return false; // Search has failed
	}

	public String toString() {
		String image = "";
		int index = 0;
		for (Comparable item : this.store) {
			image += "\n" + (index++ < 9 ? " " : "") + index + ": " + item;
		}

		return image;
	}
	/*
	 * //ARRAY implementation public static final int DEFAULT_SIZE = 8;
	 * 
	 * private Comparable[] store; private int size;
	 * 
	 * public OrderedList() { this.store = new Comparable[DEFAULT_SIZE];
	 * this.size = 0; }
	 * 
	 * public int size() { return this.size; }
	 * 
	 * public void insert(Comparable item) { if (this.store.length == this.size)
	 * extendStore();
	 * 
	 * int index = this.size - 1; while (index >= 0 && item.compareTo(
	 * this.store[index] ) < 0 ) { this.store[index+1] = this.store[index];
	 * index--; }
	 * 
	 * this.store[index + 1] = item; this.size++; }
	 * 
	 * public void remove(Comparable item) { int index = 0; while (index <
	 * this.size && this.store[index].compareTo(item) < 0) index++;
	 * 
	 * if (index < this.size && this.store[index].compareTo(item)== 0) { for
	 * (int mover = index+1; mover < this.size; mover++) this.store[mover-1] =
	 * this.store[mover];
	 * 
	 * this.size--; } }
	 * 
	 * public boolean contains(Comparable item) { int lo = 0; int hi = this.size
	 * - 1;
	 * 
	 * while ( lo <= hi ) { int mid = (lo + hi) / 2; int key =
	 * this.store[mid].compareTo(item);
	 * 
	 * if (key == 0) return true;
	 * 
	 * if (key < 0) lo = mid + 1; else hi = mid - 1; } return false; }
	 * 
	 * public String toString() { String image = ""; for (int index = 0; index <
	 * this.size; index++) image += "\n" + (index < 9 ? " " : "") + (index + 1)
	 * + ": " + this.store[index];
	 * 
	 * return image; }
	 * 
	 * private void extendStore() { Comparable[] newStore = new
	 * Comparable[this.store.length + DEFAULT_SIZE]; for (int index = 0; index <
	 * this.store.length; index++) newStore[index] = this.store[index];
	 * this.store = newStore; }
	 */
}