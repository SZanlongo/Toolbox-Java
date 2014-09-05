package linkedList;

import java.util.Stack;

import utils.CreateUtils;
import utils.PrintUtils;

public class ConvertBSTToSortedDoublyLinkedList {

	// O(n)?
	public static linkedList.Node convert(tree.Node root) {
		if (root == null)
			return null;
		linkedList.Node head = null;
		linkedList.Node prev = null;
		Stack<tree.Node> s = new Stack<tree.Node>();
		tree.Node n = root;
		while (!s.isEmpty() || n != null) {
			if (n != null) {
				s.push(n);
				n = n.left;
			} else {
				n = s.pop();
				linkedList.Node curr = new linkedList.Node(n.value);
				curr.prev = prev;
				if (prev == null) {
					head = curr;
				} else {
					prev.next = curr;
				}
				head.prev = curr;
				curr.next = head;
				prev = curr;
				n = n.right;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		tree.Node root = CreateUtils.bstWithTenNodes();
		Node head = convert(root);
		PrintUtils.printBinaryTree(root);
		Node t = head;
		do {
			System.out.print(t.value + " ");
			t = t.next;
		} while (t != head);
	}

}
