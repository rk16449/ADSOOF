package dataStructures;

public class BinaryTree<T extends Comparable<T>> {
	// root node of the tree
	Node<T> root;
	
	public BinaryTree(T key) {
		root = new Node<T>(key);
	}
}
