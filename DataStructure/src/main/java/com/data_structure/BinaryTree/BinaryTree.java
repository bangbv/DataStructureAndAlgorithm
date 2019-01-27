package com.data_structure.BinaryTree;

import java.util.Iterator;
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

	void levelOrder(Node root, int level) {
		if (root != null) {
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
				Node tempNode = q.poll();
				System.out.print("level "+level+":"+tempNode.data+" ");
				if(tempNode.left != null) {
					q.add(tempNode.left);
				}
				if(tempNode.right != null) {
					q.add(tempNode.right);
				}
				level++;
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

	void BFS(int s,Node root, boolean[] visited) {
		visited[s] = true;
	}
	
	LinkedList<Node> search(Node root, int x, LinkedList<Node> path) {
		if (root != null) {
			path.add(root);
			if(root.data == x) {
				return path;
			}else if(x < root.data) {
				return search(root.left,x,path);
			}else {
				return search(root.right,x,path);
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	void lca(Node root, int v1, int v2) {
		LinkedList<Node> p1 =  new LinkedList<Node>();
		LinkedList<Node> p2 =  new LinkedList<Node>();
		search(root,v1,p1);
		search(root,v2,p2);
		Iterator i1 = p1.iterator();
		Iterator i2 = p2.iterator();
		while(i1.hasNext()) {
			Node n1 = (Node)i1.next();
			while(i2.hasNext()) {
				Node n2 = (Node)i2.next();
				if(n1.data == n2.data) {
					System.out.println("lca:"+n1.data);
				}
			}
		}
	}
}
