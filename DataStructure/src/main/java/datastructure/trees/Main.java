package datastructure.trees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Build Tree !");
		URL url = BinaryTree.class.getResource("input_tree.txt");
		String filename = java.net.URLDecoder.decode(url.getPath(), "UTF-8");
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
		bt.levelOrder(root);
		//bt.topView(root);
	}
	
	
}

