package linkedList;

public class CustomLinkedList {

	private Node first;

	private class Node {

		public Object data;
		public Node next;

		public Node(Object item) {
			this.data = item;
			this.next = null;
		}
	}

	public CustomLinkedList() {
		this.first = null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public void addFirst(Object item) {
		Node newbee = new Node(item);
		newbee.next = this.first;
		this.first = newbee;
	}

	public Object removeFirst() {
		if (this.first == null) {
			return null;
		}
		Object item = this.first.data;
		this.first = this.first.next;
		return item;
	}

	public boolean contains(Object item) {
		Node pointer = this.first;
		while (pointer != null && !pointer.data.equals(item)) {
			pointer = pointer.next;
		}
		return (pointer != null) && (pointer.data.equals(item));
	}

	public int size() {
		int count = 0;
		Node pointer = this.first;
		while (pointer != null) {
			count++;
			pointer = pointer.next;
		}
		return count;
	}

	public void addLast(Object item) {
		Node newbee = new Node(item);
		Node pointer = this.first;
		Node trailer = null;
		while (pointer != null) {
			trailer = pointer;
			pointer = pointer.next;
		}
		if (trailer == null) {
			this.first = newbee;
		} else {
			trailer.next = newbee;
		}
	}

	/*
	 * public void addLast(Object item){ Node store = new Node(item);
	 * if(first==null){ this.first=store; }else{ Node pointer=first;
	 * while(pointer.next!=null){ pointer=pointer.next; pointer.next=store; } }
	 * }
	 */

	public Object removeLast() {
		if (this.first == null) {
			return null;
		}
		Node pointer = this.first;
		Node trailer = null;
		while (pointer.next != null) {
			trailer = pointer;
			pointer = pointer.next;
		}
		if (trailer == null) {
			this.first = null;
		} else {
			trailer.next = null;
		}
		return pointer.data;
	}

	/*
	 * public Object removeLast(){ if(this.first==null){ return null; }
	 * if(this.first.next==null){ Object item=this.first.data; this.first=null;
	 * return item; } Node pointer = this.first; while(pointer.next.next!=null){
	 * pointer=pointer.next; Object item=pointer.next.data; pointer.next=null;
	 * return item; } }
	 */

	public void addAfter(Object incumbent, Object newItem) {
		Node pointer = this.first;
		while (pointer != null && !pointer.data.equals(incumbent)) {
			pointer = pointer.next;
		}
		if (pointer == null) {
			this.addFirst(newItem);
		} else {
			Node newbee = new Node(newItem);
			newbee.next = pointer.next;
			pointer.next = newbee;
		}
	}

	public void addBefore(Object incumbent, Object newItem) {
		Node pointer = this.first;
		Node trailer = null;
		while (pointer != null && !pointer.data.equals(incumbent)) {
			trailer = pointer;
			pointer = pointer.next;
		}
		if (pointer == null) {
			this.addFirst(newItem);
		} else {
			Node newbee = new Node(newItem);
			newbee.next = pointer;
			if (trailer == null) {
				this.first = newbee;
			} else {
				trailer.next = newbee;
			}
		}
	}

	/*
	 * public void addBefore(Object marker, Object newItem) { Node store = new
	 * Node(newItem); if(this.first == null) { this.first = null; } else { Node
	 * pointer = this.first; Node trailer = null; while(pointer != null &&
	 * !pointer.data.equals(marker)) { trailer = pointer; pointer =
	 * pointer.next; } if(pointer != null) { store.next = pointer; if(trailer ==
	 * null) { this.first = store; } else { trailer.next = store; } } else {
	 * trailer.next = store; } } }
	 */

	public void remove(Object item) {
		Node pointer = this.first;
		Node trailer = null;
		while (pointer != null && !pointer.data.equals(item)) {
			trailer = pointer;
			pointer = pointer.next;
		}
		if (pointer != null) {
			if (trailer == null) {
				this.first = pointer.next;
			} else {
				trailer.next = pointer.next;
			}
		}
	}

	@Override
	public String toString() {
		String image = this.size() + " Items";
		Node pointer = this.first;
		while (pointer != null) {
			image += "\n" + pointer.data;
			pointer = pointer.next;
		}
		return image;
	}
}