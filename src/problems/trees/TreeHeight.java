package problems.trees;

import java.util.Scanner;

class TreeHeight {
	/*
	 * class Node int data; Node left; Node right;
	 */
	public static int height(Node root) {
		
		int count = 0, countLeft = 0, countRight = 0;
		
		// base case
		if(root == null) return count;

		countLeft = 1 + height(root.left);
		
		countRight = 1 + height(root.right);

		
		if(countLeft > countRight) {
			return countLeft;
		}
		
		// Write your code here.
		return countRight;
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
		int height = height(root);
		System.out.println(height);
	}
}