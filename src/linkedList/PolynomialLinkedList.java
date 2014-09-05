package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class PolynomialLinkedList {

	private LinkedList polynomial;

	// create linkedlist

	private String output(ListIterator out) {
		if (!out.hasNext()) {
			return "";
		}
		return out.next() + " " + output(out);
	}

	// helper for tostring
	// it goes through the list and prints the values

	private class Term {
		// create terms

		int coefficient;
		int exponent;

		private Term(int coefficient, int exponent) {
			this.coefficient = coefficient;
			this.exponent = exponent;
		}

		// add exp and coef to term

		@Override
		public String toString() {
			return this.coefficient + "x^" + this.exponent;
		}
		// output the coefficient and exponent in a nice way
		// otherwise you get garbage
	}

	private class Node {
		// create node

		Term data;
		Node next;

		private Node(Term term, Node node) {
			this.data = term;
			this.next = node;
		}

		private Node() {
			data = null;
			next = null;
		}
	}

	private Node header;

	// i don't think i need this now

	public PolynomialLinkedList() {
		polynomial = new LinkedList<Term>();
	}

	// create linkedlist with no terms

	private PolynomialLinkedList(Node node) {
		header = node;
	}

	// create header

	public void addTerm(int coefficient, int exponent) {
		// add terms given coef and exp
		ListIterator iterator = polynomial.listIterator();

		if (polynomial.size() == 0) {
			iterator.add(new Term(coefficient, exponent));
			return;
		}
		// if 0, add the term

		while (iterator.hasNext()) {
			Term term1 = (Term) iterator.next();
			if (exponent == term1.exponent) {
				iterator.set(new Term(coefficient + term1.coefficient, exponent));
				return;
			}
			// if exp are =, then just add the coefs
			if (exponent < term1.exponent) {
				Term term2 = new Term(coefficient, exponent);
				iterator.previous();
				iterator.add(term2);
				return;
			}
			// if smaller, add before the other
		}
		Term term3 = new Term(coefficient, exponent);
		iterator.add(term3);
		// if it made it here, then its bigger, so add after
		return;
	}

	public PolynomialLinkedList polyAdd(PolynomialLinkedList p) {
		// add polynomials
		ListIterator iterator1 = polynomial.listIterator();
		Term term1;
		ListIterator iterator2 = polynomial.listIterator();
		Term term2;
		PolynomialLinkedList addition = new PolynomialLinkedList();
		// goes through list (both)
		if (iterator1.hasNext()) {
			while (iterator1.hasNext()) {
				term1 = (Term) iterator1.next();
				addition.polynomial.add(new Term(term1.coefficient, term1.exponent));
			}
		}
		if (iterator2.hasNext()) {
			while (iterator2.hasNext()) {
				term2 = (Term) iterator2.next();
				addition.polynomial.add(new Term(term2.coefficient, term2.exponent));
			}
		}
		while ((iterator1.hasNext()) && (iterator2.hasNext())) {
			term1 = (Term) iterator1.next();
			iterator1.previous();
			term2 = (Term) iterator2.next();
			iterator2.previous();
			if (term1.exponent == term2.exponent) {
				// same exp, so add coefs and keep exp
				addition.polynomial.add(new Term(term1.coefficient + term2.coefficient,
						term1.exponent));
				iterator1.next();
				iterator2.next();
			} // smaller coef, so add before the other
			if (term1.exponent < term2.exponent) {
				addition.polynomial.add(new Term(term1.coefficient, term2.exponent));
				iterator1.next();
			} // larger, so add after
			else {
				addition.polynomial.add(new Term(term2.coefficient, term2.exponent));
				iterator2.next();
			}
		}
		return addition;
		// return answer
	}

	private Node polyAdd(Node poly1, Node poly2) {
		// helper for the add method
		// recursive part
		Node answer = new Node();

		if (poly1 == null) {
			poly1 = poly2;
			poly2 = null;
		}

		if (poly1 == null) {
			return null;
		}

		if (poly2 == null) {
			answer.next.data = poly1.data;
			poly1 = poly1.next;
		} else {

			if (poly1.next.data.exponent == poly2.next.data.exponent) {
				answer.next.data = new Term(poly1.next.data.coefficient
						+ poly2.next.data.coefficient, poly1.next.data.exponent);
				poly1 = poly1.next;
				poly2 = poly2.next;
			} else {

				if (poly1.next.data.exponent < poly2.next.data.exponent) {
					Node t = poly1;
					poly1 = poly2;
					poly2 = t;
				}
				answer.data = poly1.next.data;
				poly1 = poly1.next;
			}
		}
		answer.next = polyAdd(poly1, poly2);
		return answer;
	}

	public PolynomialLinkedList polyMultiply(PolynomialLinkedList p) {
		// multiply polynomials
		Iterator<Term> iterator1 = this.polynomial.iterator();
		PolynomialLinkedList multiplied = new PolynomialLinkedList();
		// go through list
		while (iterator1.hasNext()) {
			Term term1 = iterator1.next();
			Iterator<Term> iterator2 = p.polynomial.iterator();
			while (iterator2.hasNext()) {
				Term term2 = iterator2.next();
				// actually multiplies them
				multiplied.addTerm(term1.coefficient * term2.coefficient, term1.exponent
						* term2.exponent);
			}
		}
		return multiplied;
		// return answer
	}

	private Node polyMultiply(Node poly1, Node poly2) {
		// helper method for multiply
		// recursive part
		Node answer = new Node();

		if ((poly1 == null) || (poly2 == null)) {
			return null;
			// both empty, so return null
		} else {
			answer.next.data = new Term(poly1.next.data.coefficient * poly2.next.data.coefficient,
					poly1.next.data.exponent + poly2.next.data.exponent);
			poly1 = poly1.next;
			poly2 = poly2.next;
			// multiply
		}
		answer.next = polyMultiply(poly1, poly2);
		return answer;
		// return answer
	}

	@Override
	public String toString() {
		// output answer using the helper method at top
		ListIterator out = polynomial.listIterator();
		return output(out);
	}
}
