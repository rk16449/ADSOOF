package dataStructures;

public class Node<T> {
	
	T key;
	Node<T> left, right;
	
	public Node(T key) {
		this.key = key;
		// set left and right nodes to null
		left = right = null;
	}
}
