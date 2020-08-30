package com.algorithm.interview.line;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LineQuestion6 {
    public static void main(String[] args) throws Exception {
        System.out.println("LineQuestion6");
        ClassLoader classLoader = LineQuestion6.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("line_q6.txt").getPath(), "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(br.readLine());
        Graph graph = new Graph(n);
        String line;
        while((line = br.readLine())!= null){
            String[] pair = line.split(" ");
            graph.addEdge(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]));
        }
        if (graph.isCyclic())
            System.out.println("true");
        else
            System.out.println("false");
        br.close();
    }
}

class Graph {

    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {
        if (recStack[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;
        recStack[i] = false;
        return false;
    }

    void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }
}
