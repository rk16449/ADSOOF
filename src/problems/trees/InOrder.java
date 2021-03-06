package problems.trees;

import java.util.Scanner;

class InOrder {
	/*
	 * you only have to complete the function given below. Node is defined as
	 * 
	 * class Node { int data; Node left; Node right; }
	 * 
	 */

	public static void inOrder(Node root) {
		
		// return back up stack if null
		if(root == null) return;
		
		// traverse left
		inOrder(root.left);
		
		// print
		System.out.println(root.data + " ");
		
		// traverse right
		inOrder(root.right);
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
		inOrder(root);
	}
}