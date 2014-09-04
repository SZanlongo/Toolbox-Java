package dataStructures;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class BinaryNode<T> {

	// the fields
	private T element;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	/** Create a default binary node */
	public BinaryNode() {
		this(null, null, null);
	}

	// create a node with given value and children
	public BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
		element = theElement;
		left = lt;
		right = rt;
	}

	// return the element
	public T getElement() {
		return element;
	}

	// return the left child
	public BinaryNode<T> getLeft() {
		return left;
	}

	// return the right child
	public BinaryNode<T> getRight() {
		return right;
	}

	// set the element to a given value
	// @param x is the new value
	public void setElement(T x) {
		element = x;
	}

	// set the left child
	// @param t is the left child
	public void setLeft(BinaryNode<T> t) {
		left = t;
	}

	// set the right child
	// @param t is the right child
	public void setRight(BinaryNode<T> t) {
		right = t;
	}

	// @return the size of the subtree at node t
	public static <T> int size(BinaryNode<T> t) {
		if (t == null) {
			return 0;
		} else {
			return 1 + size(t.left) + size(t.right);
		}
	}

	// @return the height of the subtree of node t
	public static <T> int height(BinaryNode<T> t) {
		if (t == null) {
			return -1;
		} else {
			return 1 + Math.max(height(t.left), height(t.right));
		}
	}

	// find if an item occurs in the tree
	// @param inq is the inquiry
	public BinaryNode<T> find(T inq) {
		if (element.equals(inq)) {
			return this;
		}
		BinaryNode<T> out = null;
		if (left != null) {
			out = left.find(inq);
		}
		if (out != null) {
			return out;
		} else if (right != null) {
			out = right.find(inq);
		}
		return out;
	}

	// create a duplicate tree
	// @return the root of the duplicate tree
	public BinaryNode<T> duplicate() {
		BinaryNode<T> root = new BinaryNode<T>(element, null, null);
		if (left != null) // create a duplicate tree for the left subtree
		{
			root.left = left.duplicate();
		}
		if (right != null) {
			root.right = right.duplicate();
		}
		return root;
	}

	// print the tree elements in preorder
	public void printPreOrder() {
		System.out.println(element);
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}

	// print the tree elements in postorder // iterativeInorder
	public void iterativePreOrder() {
		Stack<BinaryNode<T>> s = new Stack<BinaryNode<T>>();
		BinaryNode<T> current = this;
		while (current != null || !s.empty()) {
			if (current != null) {
				System.out.println(current.element);
				// process it, put it in the stack, and go left
				s.push(current);
				current = current.left;
			} else // pop the stack and go right
			{
				current = s.pop();
				current = current.right;
			}
		}
	}

	public void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.println(element);
	}

	// print the tree elements in inorder
	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println(element);
		if (right != null) {
			right.printInOrder();
		}
	}

	// takes as input the preorder and the inorder traversals of a binary tree
	// the method constructs a tree that has these traversals and returns the
	// root of the tree
	public static <T> BinaryNode<T> prePlusIn(T[] pre, T[] in) {
		// if pre or in are null, invalid
		// if lengths not equal, invalid
		if (pre == null || in == null || pre.length != in.length) {
			throw new IllegalArgumentException();
		}
		// if empty, then there are no more items to process
		// return null
		if (pre.length == 0) {
			return null;
		}
		// create new node
		// the first element in preorder is the root
		BinaryNode<T> node = new BinaryNode(pre[0], null, null);
		// location of root node in inorder
		int rLoc = 0;
		// find the node in inorder
		while (in[rLoc] != pre[0]) {
			if (rLoc >= pre.length - 1) {
				throw new IllegalArgumentException();
			}
			rLoc++;
		}
		// create new pre and in arrays
		T[] newPre = (T[]) Array.newInstance(pre[0].getClass(), rLoc);
		T[] newIn = (T[]) Array.newInstance(in[0].getClass(), rLoc);
		// everything to the left of the root is a left subtree
		System.arraycopy(pre, 1, newPre, 0, rLoc);
		System.arraycopy(in, 0, newIn, 0, rLoc);
		// create new node and set as left of root
		// recursive, this will call itself
		// now, the left node will check for its own left and right
		node.setLeft(prePlusIn(newPre, newIn));
		// right is all items to right of root
		newPre = (T[]) Array.newInstance(pre[0].getClass(), pre.length - rLoc
				- 1);
		newIn = (T[]) Array.newInstance(in[0].getClass(), in.length - rLoc - 1);
		System.arraycopy(pre, rLoc + 1, newPre, 0, in.length - rLoc - 1);
		System.arraycopy(in, rLoc + 1, newIn, 0, in.length - rLoc - 1);
		// create new node and set as right of node
		// recursive
		// now, the right node will check for its own left and right
		node.setRight(prePlusIn(newPre, newIn));
		// now that node is complete (with left and right), return it
		return node;
	}

	// The method prints the nodes of the tree with root this in postorder,
	// without using recursion
	public void iterativePostOrder() {
		if (this == null) {
			throw new IllegalArgumentException();
		}
		// work is the working list of items
		Stack<BinaryNode> work = new Stack();
		// the previous node that was processed
		BinaryNode previous = null;
		// add "this" to work
		work.push(this);
		// while work is empty, continue
		// that is, keep going while there are nodes to process
		while (!work.empty()) {
			// remove node from "top" and add to end of sorted
			BinaryNode<T> tNode = work.peek();
			// if there are left and right nodes, add them to work
			// if previous is tNodes parent, then going down
			if (previous == null || previous.getLeft() == tNode
					|| previous.getRight() == tNode) {
				// has left or right? add to stack
				if (tNode.getLeft() != null) {
					work.push(tNode.getLeft());
				} else if (tNode.getRight() != null) {
					work.push(tNode.getRight());
				}
				// if previous is tNodes left child, then going up from left
				// is there a right? yes, go down, no, then print
			} else if (previous == tNode.getLeft()) {
				// if previous is tNodes right child, then going up from right,
				// so no more children, so print the node
				if (tNode.getRight() != null) {
					work.push(tNode.getRight());
				}
				// no left or right, so end, so print
			} else {
				System.out.println(tNode.getElement());
				work.pop();
			}
			previous = tNode;
		}
	}

	// The method prints the nodes of the tree with root this using
	// breadthsearch
	public void printByLevels() {
		if (this == null) {
			throw new IllegalArgumentException();
		}
		// counter
		int i = 0;
		// list keeps all the nodes in correct order
		LinkedList<BinaryNode> list = new LinkedList();
		// level keeps track of the level of each node
		LinkedList<Integer> level = new LinkedList();
		// unless null, add "this" to list
		if (this == null) {
			throw new IllegalArgumentException();
		} else {
			list.addLast(this);
			level.addLast(i);
		}
		// while there are nodes to process

		while (i < size(this)) {
			// get first item from list
			BinaryNode<T> tNode = list.get(i);
			// if there is a left or right, add them to list
			// also add what level they are on
			if (tNode.getLeft() != null) {
				list.addLast(tNode.getLeft());
				level.addLast(level.get(i) + 1);
			}
			if (tNode.getRight() != null) {
				list.addLast(tNode.getRight());
				level.addLast(level.get(i) + 1);
			}
			// increment level
			i++;
		}
		// output
		String out = "Level" + "\t" + "Nodes";
		// what wa the last level that was printed?
		int lastLevel = -1;
		// for every node
		for (int x = 0; x < i; x++) {
			// if this nodes level was same as previous nodes level. print on
			// same level
			if (level.get(x) == lastLevel) {
				out += list.get(x).getElement() + "  ";
				// else, print on a new level
			} else {
				out += "\n" + level.get(x) + "\t" + list.get(x).getElement()
						+ "  ";
				lastLevel++;
			}
		}
		System.out.println(out);
	}

	// takes as input the postorder and the inorder traversals of a binary tree.
	// The method constructs a tree that has these traversals and returns the
	// root of the tree
	public static <T> BinaryNode<T> postPlusIn(T[] post, T[] in) {
		// if post or in are null, invalid
		// if lengths dont match, then invalid
		if (post == null || in == null || post.length != in.length) {
			throw new IllegalArgumentException();
		}
		// nothing to process, so return null
		if (post.length == 0) {
			return null;
		}
		// create new node with last item from post (the root)
		BinaryNode<T> node = new BinaryNode(post[post.length - 1], null, null);
		// the location of the node in "in"
		int rLoc = 0;
		// find the node in "in"z
		while (in[rLoc] != post[post.length - 1]) {
			if (rLoc >= post.length - 1) {
				throw new IllegalArgumentException();
			}
			rLoc++;
		}
		// create new versions of in and post with correct lengths
		T[] newPost = (T[]) Array.newInstance(post[0].getClass(), rLoc);
		T[] newIn = (T[]) Array.newInstance(in[0].getClass(), rLoc);
		// everything to left of root is in the left subtree
		System.arraycopy(post, 0, newPost, 0, rLoc);
		System.arraycopy(in, 0, newIn, 0, rLoc);
		// recursive
		// create the new subtree and set as left of current node
		node.setLeft(postPlusIn(newPost, newIn));
		newPost = (T[]) Array.newInstance(post[0].getClass(), post.length
				- rLoc - 1);
		newIn = (T[]) Array.newInstance(in[0].getClass(), in.length - rLoc - 1);
		// everything to the right of root is in the right subtree
		System.arraycopy(post, rLoc, newPost, 0, in.length - rLoc - 1);
		System.arraycopy(in, rLoc + 1, newIn, 0, in.length - rLoc - 1);
		// recursive
		// set new subtree as right of current node
		node.setRight(postPlusIn(newPost, newIn));
		// now that node has left and right, its complete, so return
		return node;
	}

	// The method prints the nodes of the tree with root this in postorder,
	// without using recursion.
	public void iterativeInOrder() {
		if (this == null) {
			throw new IllegalArgumentException();
		}
		// rNode = "this"
		BinaryNode<T> rNode = this;
		// stack will keep the nodes in correct order
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		// if not null, or if stack is not empty, loop
		while (!stack.isEmpty() || rNode != null) {
			if (rNode != null) {
				// add node to stack
				stack.push(rNode);
				// replace this node with its left sub-node and loop again
				rNode = rNode.getLeft();
			} else {
				// replace this node with the top from stack and output
				rNode = stack.pop();
				System.out.println(rNode.element);
				// now, replace this node with the sub-node on the right and
				// loop
				rNode = rNode.getRight();
			}
		}
	}
}