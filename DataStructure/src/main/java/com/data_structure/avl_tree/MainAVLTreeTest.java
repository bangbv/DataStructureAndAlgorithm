package com.data_structure.avl_tree;

import java.io.BufferedReader;
import java.io.FileReader;

import com.data_structure.BinaryTree.BinaryTree;

public class MainAVLTreeTest {

	public static void main(String[] args) throws Exception {
		System.out.println("Build Tree !");
		ClassLoader classLoader = BinaryTree.class.getClassLoader();
		String filename = java.net.URLDecoder.decode(classLoader.getResource("input_avl_tree.txt").getPath(), "UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		int t = Integer.valueOf(line);
		AVLNode root = null;
		AVLTree avlt = new AVLTree();
		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < t; i++) {
			int data = Integer.valueOf(input[i]);
			root = avlt.insert(root, data);
		}
		reader.close();
		//avlt.topView(root);
	}
	
	
}

