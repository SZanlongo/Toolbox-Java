package dataStructures;

import java.util.LinkedList;

public class Stack {

	private LinkedList<Object> store;

	public Stack() {
		this.store = new LinkedList<Object>();
	}

	public boolean empty() {
		return this.store.isEmpty();
	}

	public Object peek() {
		return (this.store.isEmpty() ? null : this.store.getFirst());
	}

	public void push(Object item) {
		this.store.addFirst(item);
	}

	public Object pop() {
		if (this.store.isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		}

		return this.store.removeFirst();
	}
}