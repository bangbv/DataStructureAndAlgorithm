package com.algorithm.GraphTheory;

import java.util.LinkedList;

public class MyGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public MyGraph(int v) {
        V = v;
        adj = new LinkedList[v+1];
        for (int i = 1; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList();
        queue.add(s);
        visited[s] = true;
        while (queue.size() != 0) {
            int n = queue.poll();
            System.out.print(n + " ");
            for (Integer integer : adj[n]) {
                int child = integer;
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                System.out.println(n + " ");
                DFS(n, visited);
            }
        }
    }
}
