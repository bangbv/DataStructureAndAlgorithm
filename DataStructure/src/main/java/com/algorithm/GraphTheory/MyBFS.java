package com.algorithm.GraphTheory;

public class MyBFS {

	public static void main(String[] args) {
		MyGraph g = new MyGraph(6);
		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		g.addEdge(1, 5);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(1);
	}

}
