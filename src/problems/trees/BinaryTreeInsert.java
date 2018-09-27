package problems.trees;

import java.util.*;
import java.io.*;

class BinaryTreeInsert {

	public static void preOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	/*
	 * Node is defined as : class Node int data; Node left; Node right;
	 * 
	 */
	public static Node insert(Node root, int data) {

		// empty node created, return a new Node and go back up the stack
		if(root == null) return new Node(data);
		
		// less than value found
		if(data < root.data) {
			root.left = insert(root.left, data);
		}else {
			// greater than value
			root.right = insert(root.right, data);
		}
		
		// return the root
		return root;
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
		preOrder(root);
	}
}