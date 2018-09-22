package dataStructures;

// Methods based off HackerRank

public class Node<T extends Comparable<T>> {
	
	T key;
	Node<T> left, right;
	
	public Node(T key) {
		this.key = key;
		// set left and right nodes to null
		left = right = null;
	}
	
	// Returns true if we are a leaf, no left or right nodes
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
	
	public void insert(T value) {
		
		// Insert onto the left side if value is less than key
		if(key.compareTo(value) <= 0) {
			if(left == null) {
				left = new Node<T>(value);
			}else {
				left.insert(value);
			}
		}else {
			if(right == null) {
				right = new Node<T>(value);
			}else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(T value) {
		if(key == value) {
			return true;
		}else if(value.compareTo(key) < 0) {
			if(left == null) {
				return false;
			}else {
				return left.contains(value);
			}
		}else {
			if(right == null) {
				return false;
			}else {
				return right.contains(value);
			}
		}
	}
	
	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		}
		System.out.println(key);
		if(right != null) {
			right.printInOrder();
		}
	}
}
