package dataStructures;

import java.util.LinkedList;

public class Queue {

	private final LinkedList<Object> store;

	public Queue() {
		this.store = new LinkedList<Object>();
	}

	public boolean empty() {
		return this.store.isEmpty();
	}

	public Object peek() {
		return (this.store.isEmpty() ? null : this.store.getFirst());
	}

	public void enQueue(Object item) {
		this.store.addLast(item);
	}

	@SuppressWarnings("unused")
	private Object deQueue() {
		if (this.store.isEmpty()) {
			throw new RuntimeException("Queue Underflow");
		}

		return this.store.removeFirst();
	}
}
