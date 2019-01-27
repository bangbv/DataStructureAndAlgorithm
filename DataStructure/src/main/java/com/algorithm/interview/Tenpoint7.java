package com.algorithm.interview;

import java.util.LinkedList;

public class Tenpoint7 {

	public static void main(String[] args) {
		int V = 6;
		Graph g = new Graph(V);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		
		subGraph(g, 3);
	}

	static LinkedList<Integer> subGraph(Graph g,int n) {
		if((g!=null) && n>0) {
			return g.BFS(n);
		}else {
			System.out.println("error!");
			return null;
		}
	}
}
