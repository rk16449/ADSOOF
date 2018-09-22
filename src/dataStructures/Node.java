package dataStructures;

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
}
