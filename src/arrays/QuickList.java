package arrays;

import java.util.ArrayList;

//http://users.cis.fiu.edu/~pestaina/QuickList.java
public class QuickList {

	private final ArrayList<String> store;
	private final String title;

	public QuickList(String title) {
		this.title = title;
		this.store = new ArrayList<String>();
	}

	public QuickList() {
		this(null);
	}

	public int count() {
		return this.store.size();
	}

	public void add(String item) {
		if (!this.store.contains(item)) {
			this.store.add(item);
		}
	}

	public boolean has(String item) {
		return this.store.contains(item);
	}

	public void delete(String item) {
		this.store.remove(item);
	}

	@SuppressWarnings("unused")
	private int indexOf(String item) {
		for (int i = 0; i < this.store.size(); i++) {
			if (this.store.get(i).equalsIgnoreCase(item)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public String toString() {
		String image = "";
		if (this.title != null) {
			image = this.title;
		}
		image += " " + this.store.size() + " Entries";

		for (String item : this.store) {
			image += "\n" + item;
		}

		return image;
	}
}