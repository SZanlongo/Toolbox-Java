package dataStructures;

public class BinaryNodeDriver {

	public static void main(String[] args) {

		System.out.println("Testing Binary Trees");
		System.out.println("====================");

		System.out.println("We form the tree shown below ");
		System.out.println("Mark <---- Rose ----> Bill");
		System.out.println("Sue  <---- Mark ----> Jack");
		System.out.println("John <---- Sue ----> Dan");
		System.out.println("Mary <---- John ----> null");
		System.out.println("null <---- Mary ----> Flor");
		System.out.println("null <---- Flor ----> null");
		System.out.println("Larry <---- Dan ----> Bertha");
		System.out.println("null <---- Larry ----> null");
		System.out.println("George <---- Bertha ----> null");
		System.out.println("null <---- George ----> null");
		System.out.println("null <---- Jack ----> Zoila");
		System.out.println("Rich <---- Bill ----> Karen");
		System.out.println("null <---- Rich ----> Faith");
		System.out.println("null <---- Faith ----> null");
		System.out.println("Ann <---- Karen ----> null");
		System.out.println("null <---- Ann ----> null");
		System.out.println("null <---- Zoila ----> null");
		System.out.println("The root is Rose.");
		BinaryNode<String> n16 = new BinaryNode<String>("George", null, null);
		BinaryNode<String> n15 = new BinaryNode<String>("Flor", null, null);
		BinaryNode<String> n14 = new BinaryNode<String>("Bertha", n16, null);
		BinaryNode<String> n13 = new BinaryNode<String>("Larry", null, null);
		BinaryNode<String> n12 = new BinaryNode<String>("Mary", null, n15);
		BinaryNode<String> n11 = new BinaryNode<String>("Ann", null, null);
		BinaryNode<String> n10 = new BinaryNode<String>("Faith", null, null);
		BinaryNode<String> n9 = new BinaryNode<String>("Zoila", null, null);
		BinaryNode<String> n8 = new BinaryNode<String>("Dan", n13, n14);
		BinaryNode<String> n7 = new BinaryNode<String>("John", n12, null);
		BinaryNode<String> n6 = new BinaryNode<String>("Karen", n11, null);
		BinaryNode<String> n5 = new BinaryNode<String>("Rich", null, n10);
		BinaryNode<String> n4 = new BinaryNode<String>("Jack", null, n9);
		BinaryNode<String> n3 = new BinaryNode<String>("Sue", n7, n8);
		BinaryNode<String> n2 = new BinaryNode<String>("Bill", n5, n6);
		BinaryNode<String> n1 = new BinaryNode<String>("Mark", n3, n4);
		BinaryNode<String> n0 = new BinaryNode<String>("Rose", n1, n2);

		// test the traversals
		System.out.println("\nThe tree in iterative post order is: ");
		n0.iterativePostOrder();

		System.out.println("\nThe tree in post order is: ");
		n0.printPostOrder();

		System.out.println("\nThe tree in iterative in order is: ");
		n0.iterativeInOrder();

		System.out.println("\nThe tree in in order is: ");
		n0.printInOrder();

		// test the 2 methods that create trees
		String[] pre = { "Bill", "Mark", "Mary", "Sue", "Ann", "John", "Flor",
				"Peter", "Zoila" };
		String[] in = { "Mary", "Sue", "Mark", "Bill", "John", "Flor", "Ann",
				"Zoila", "Peter" };
		String[] post = { "Sue", "Mary", "Mark", "Flor", "John", "Zoila",
				"Peter", "Ann", "Bill" };
		System.out.println("\nTesting prePlusIn:\nThe preorder is : ");
		for (String n : pre) {
			System.out.println(n);
		}
		System.out.println("\nThe in order is: ");
		for (String n : in) {
			System.out.println(n);
		}
		// form the tree
		BinaryNode<String> test1 = BinaryNode.prePlusIn(pre, in);
		System.out.println("\nThe new tree in preorder is: ");
		test1.printPreOrder();
		System.out.println("\nThe new tree in inorder is: ");
		test1.printInOrder();

		// test postPlusIn
		System.out.println("\nTesting postPlusIn:\nThe postorder is : ");
		for (String n : post) {
			System.out.println(n);
		}

		System.out.println("\nThe in order is: ");
		for (String n : in) {
			System.out.println(n);
		}

		// form the tree
		BinaryNode<String> test2 = BinaryNode.postPlusIn(post, in);
		System.out.println("\nThe new tree in postorder is: ");
		test2.printPostOrder();
		System.out.println("\nThe new tree in in order is:");
		test2.printInOrder();

		// test printByLevels
		System.out.println("\nWe test print by levels.");
		System.out.println("The original tree by levels is :");
		n0.printByLevels();

	}
}