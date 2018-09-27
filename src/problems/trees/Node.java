package problems.trees;

public class Node {
	public Node left;
	public Node right;
	public int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
