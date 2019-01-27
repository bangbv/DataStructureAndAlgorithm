package com.algorithm.interview;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
	int V;
	LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	Graph(int V){
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int s, int d) {
		this.adj[s].add(d);
	}
	
	LinkedList<Integer> BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> subG = new LinkedList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		while(queue.size() != 0) {
			s= queue.poll();
			System.out.print(s+" ");
			subG.add(s);
			ListIterator<Integer> l = adj[s].listIterator();
			while(l.hasNext()) {
				int n = l.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		System.out.println();
		return subG;
	}
}
