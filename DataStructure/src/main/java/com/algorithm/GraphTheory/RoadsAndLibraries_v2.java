package com.algorithm.GraphTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/*
It's easy to overthink this one.
If the cost of a road is >= the cost of a library, just build a library at each node.
Otherwise, use DFS to get the number of nodes (ct) in each connected component. 
Put 1 library in each component, 
and the total per component cost is simply ct-1 (a road to connect to each node in the compomnent) * cost of a road + cost of one library.
You'll never put more than one library per component because once you're adding an additional node to a component, 
the cost of just building a road will always be cheaper than the cost of disconnecting the node (not building a road) 
and building a library instead.
 * */
public class RoadsAndLibraries_v2 {
	// Complete the roadsAndLibraries function below.
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		if (c_road >= c_lib) {
			return (long) n * c_lib;
		} else {
			// build graph
			Graph g = new Graph(n);
			for (int[] c : cities) {
				g.addEdge(c[0], c[1]);
			}
			boolean[] visited = new boolean[n + 1];
			long rs = 0;
			int count = 0;
			// each connected component
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					count = g.DFS(i, visited, count);
					if (count > 1) {
						rs = rs + c_lib + ((count - 1) * c_road);
					} else {
						rs = rs + c_lib;
					}
					count = 0;
				}
			}
			return rs;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/Users/bvbang/Documents/workspace/DataStructureAndAlgorithm/DataStructure/src/main/resources/input04.txt"));
		int q = Integer.valueOf(reader.readLine());
		for (int qItr = 0; qItr < q; qItr++) {
			String[] ls = reader.readLine().split(" ");
			int n = Integer.parseInt(ls[0]);
			int m = Integer.parseInt(ls[1]);
			int c_lib = Integer.parseInt(ls[2]);
			int c_road = Integer.parseInt(ls[3]);
			int[][] cities = new int[m][2];
			for (int i = 0; i < m; i++) {
				String[] citiesRowItems = reader.readLine().split(" ");
				for (int j = 0; j < 2; j++) {
					int citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = citiesItem;
				}
			}
			long result = roadsAndLibraries(n, c_lib, c_road, cities);
			System.out.println(result);

		}
		reader.close();
	}
}

class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph(int v) {
		this.V = v;
		adj = new LinkedList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	int DFS(int v, boolean visited[], int count) {
		if (!visited[v]) {
			count++;
		}
		visited[v] = true;
		Iterator<Integer> lw = adj[v].iterator();
		while (lw.hasNext()) {
			int nv = lw.next();
			if (!visited[nv]) {
				visited[nv] = true;
				count++;
				count = DFS(nv, visited, count);
			}
		}
		return count;
	}
}
