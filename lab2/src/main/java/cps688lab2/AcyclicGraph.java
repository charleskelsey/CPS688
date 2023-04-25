 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cps688lab2;

import java.util.*;

/**
 *
 * @author charl
 */
public class AcyclicGraph {

    /**
     * @param args the command line arguments
     */
    private int V; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list for each vertex
    
    //constructor
    public AcyclicGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // function to check if the graph has a cycle
    // Returns true if the graph contains a cycle, else false.
    boolean hasCycle() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean visited[] = new boolean[V];
        
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < V; i++) {
            // Don't recur for u if already visited
            if (!visited[i] && isCyclicUtil(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    // utility function for hasCycle()
    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;
        
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            
            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[n]) {
                if (isCyclicUtil(n, visited, v))
                    return true;
                
            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            } else if (n != parent)
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();  //scans the number of vertices
            int e = scanner.nextInt();  //scans the number of edges
            
            // create a graph
            AcyclicGraph g = new AcyclicGraph(n);
            
            // add edges
            for (int i = 0; i < e; i++) {   //scans the vertices that are connected by an edge
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                g.addEdge(u, v);
            }
            
            // if graph contains a cycle print "no", else print "yes"
            if (g.hasCycle()) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
    
}
