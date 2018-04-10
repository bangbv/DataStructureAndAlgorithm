package datastructure.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	int height(Node root) {
		if (root == null) {
			return 0;
		}
		int h_r = 1;
		int h_l = 1;
		if (root != null) {
			h_l += height(root.left);
			h_r += height(root.right);
		}
		if (h_l > h_r) {
			return h_l;
		} else {
			return h_r;
		}
	}

	void levelOrder(Node root) {
		if (root != null) {
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
				Node tempNode = q.poll();
				System.out.print(tempNode.data+" ");
				if(tempNode.left != null) {
					q.add(tempNode.left);
				}
				if(tempNode.right != null) {
					q.add(tempNode.right);
				}
			}
		}
	}
	
	void topView(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			topView(root.right);
		}
	}

	Node insert(Node root, int data) {
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

}
