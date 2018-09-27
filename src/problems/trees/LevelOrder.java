package problems.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class LevelOrder {
	/*
	 * 
	 * class Node int data; Node left; Node right;
	 */
	public static void levelOrder(Node root) {
		// uses breadth first (queue) (iterative approach)
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			Node node = (Node) q.poll();
			System.out.print(node.data + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);
	}
}