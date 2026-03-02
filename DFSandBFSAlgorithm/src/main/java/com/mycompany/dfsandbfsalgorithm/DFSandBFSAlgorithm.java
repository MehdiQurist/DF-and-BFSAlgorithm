
package com.mycompany.dfsandbfsalgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSandBFSAlgorithm {

    
    
  public static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSUtil(int v, boolean visited[]) {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        void DFS(int v) {
            boolean visited[] = new boolean[V];
            DFSUtil(v, visited);
        }

        void BFS(int s) {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + " ");

                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(10); 
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 8);
        g.addEdge(5, 9);

        System.out.println("DFS traversal starting from vertex 1:");
        g.DFS(1);
        System.out.println("\nBFS traversal starting from vertex 1:");
        g.BFS(1);
    }
}


