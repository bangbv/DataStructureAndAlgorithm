package datastructure.BinaryTree;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Build Tree !");
		ClassLoader classLoader = BinaryTree.class.getClassLoader();
		String filename = java.net.URLDecoder.decode(classLoader.getResource("input_b_tree.txt").getPath(), "UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		int t = Integer.valueOf(line);
		Node root = null;
		BinaryTree bt = new BinaryTree();
		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < t; i++) {
			int data = Integer.valueOf(input[i]);
			root = bt.insert(root, data);
		}
		reader.close();
		//bt.levelOrder(root,0);
		//bt.topView(root);
		bt.lca(root, 6, 3);
	}
}

