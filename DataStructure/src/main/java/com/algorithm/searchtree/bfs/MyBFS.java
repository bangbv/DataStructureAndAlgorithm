package com.algorithm.searchtree.bfs;

public class MyBFS {

	public static void main(String[] args) {
		MyGraph g = new MyGraph(7);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		g.addEdge(2, 5);
		g.addEdge(2, 4);
		g.addEdge(3, 1);
		//g.addEdge(3, 5);
		g.addEdge(4, 2);
		//g.addEdge(4, 5);
		g.addEdge(4, 6);
		//g.addEdge(5, 3);
		g.addEdge(5, 2);
		//g.addEdge(5, 4);
		g.addEdge(6, 4);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		//g.BFS(1);
		boolean visited[] = new boolean[7];
		g.DFS(1, visited);
	}

}
