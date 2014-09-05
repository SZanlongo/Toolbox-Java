package linkedList;

import javax.swing.JOptionPane;

public class PolynomialLinkedListDriver {

	public static void main(String[] args) {
		PolynomialLinkedList p1 = new PolynomialLinkedList();
		PolynomialLinkedList p2 = new PolynomialLinkedList();
		PolynomialLinkedList p0 = new PolynomialLinkedList();
		p1.addTerm(5, 2);
		p1.addTerm(4, 5);
		p1.addTerm(3, 3);
		p1.addTerm(1, 2);
		p1.addTerm(5, 6);
		p2.addTerm(3, 8);
		p2.addTerm(2, 5);
		p2.addTerm(1, 3);
		PolynomialLinkedList p3 = p1.polyAdd(p2);
		JOptionPane.showMessageDialog(null, "p1 is " + p1 + "\np2 is " + p2 + "\np1+p2 is " + p3);
		PolynomialLinkedList p4 = p1.polyMultiply(p2);
		JOptionPane.showMessageDialog(null, "p1 is " + p1 + "\np2 is " + p2 + "\np1*p2 is " + p4);
		PolynomialLinkedList p5 = p2.polyMultiply(p2);
		JOptionPane.showMessageDialog(null, "p2 is " + p2 + "\np2*p2 is " + p5);
		PolynomialLinkedList p6 = p0.polyMultiply(p2);
		JOptionPane.showMessageDialog(null, "p0 is " + p0 + "\n" + "p2 is " + p2 + "\np0*p2 is "
				+ p6);
		PolynomialLinkedList p7 = p0.polyAdd(p2);
		JOptionPane.showMessageDialog(null, "p0 is " + p0 + "\n" + "p2 is " + p2 + "\np0+p2 is "
				+ p7);
		p1 = p1.polyAdd(p2);
		JOptionPane.showMessageDialog(null, "After p1 = p1+p2  p1 is " + p1);
		p2 = p2.polyMultiply(p2);
		JOptionPane.showMessageDialog(null, "After p2 = p2*p2  p2 is " + p2);
	}
}
