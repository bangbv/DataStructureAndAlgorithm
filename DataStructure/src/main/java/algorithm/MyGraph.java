package algorithm;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyGraph {
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public MyGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=1;i<V;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	void BFS(int s) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList();
		queue.add(s);
		visited[s] = true;
		while(queue.size() != 0) {
			int n = queue.poll();
			System.out.print(n + " ");
			ListIterator child_list = adj[n].listIterator();
			while(child_list.hasNext()) {
				int child = (int) child_list.next();
				if(!visited[child]) {
					visited[child] = true;
					queue.add(child);
				}
			}
		}
	}
}
