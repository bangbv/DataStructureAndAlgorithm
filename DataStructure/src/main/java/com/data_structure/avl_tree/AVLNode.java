package com.data_structure.avl_tree;

public class AVLNode {
	int avl; // value
	AVLNode left;
	AVLNode right;
	int ht; // height of the node
	
	public AVLNode(int avl) {
		this.avl = avl;
		this.left = null;
		this.right = null;
		this.ht = 0;
	}
}
