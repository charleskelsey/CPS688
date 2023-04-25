/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cps688lab3;

import java.util.*;

/**
 *
 * @author charl
 */
public class Graph extends Main {
    private int V;  // number of vertices
    private LinkedList<Integer>[] adj;  //adjacency lists for each vertex
    
    // constructor
    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    // function that adds an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    
    // function that does a depth-first search traversal of the graph starting
    // from a given vertex.
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int i : adj[v]) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }
    
    // method that returns the transpose of the graph
    Graph getTranspose() {
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++) {
            for (int i : adj[v]) {
                g.addEdge(i, v);
            }
        }
        return g;
    }

    // method that checks whether the graph is stringly connected or not.
    // uses two depth-first searches: one on the original graph and one on the
    // transpose of the graph.
    boolean isStronglyConnected() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        DFSUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }

        Graph gr = getTranspose();

        Arrays.fill(visited, false);

        gr.DFSUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }
}
