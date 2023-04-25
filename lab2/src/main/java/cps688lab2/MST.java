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
public class MST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();   // number of vertices
            int e = sc.nextInt();   // number of edges
            
            // create a new graph
            List<Edge>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // scans the vertices that are connected by an edge and the weight of that edge
            for (int i = 0; i < e; i++) {
                int u = sc.nextInt();   // first vertex
                int v = sc.nextInt();   // second vertex
                int w = sc.nextInt();   // the weight
                graph[u].add(new Edge(v, w));
                graph[v].add(new Edge(u, w));
            }
            
            int[] parent = new int[n];  // Array to store constructed MST
            int[] dist = new int[n];    // Key values used to pick minimum weight edge in cut
            boolean[] visited = new boolean[n];     // To represent set of vertices that are visited
            Arrays.fill(dist, Integer.MAX_VALUE);   // Initialize all keys as INFINITE
            
            // create a priority queue
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, 0));     // select an arbitrary vertex 
            // Make distance 0 so that this vertex is picked as first vertex
            dist[0] = 0;
            
            while (!pq.isEmpty()) {     //while priority queue is not empty
                Edge curr = pq.poll();      // get the first element in the priority queue
                int u = curr.vertex;        // vertex with the smallest distance in priority queue
                visited[u] = true;          // add the picked vertex to the visited set
                
                // update the distances of all the adjacent vertices to the newly 
                // added vertex and adding them to the priority queue.
                for (Edge next : graph[u]) {     //for each neighbor v of u
                    int v = next.vertex;
                    int w = next.weight;
                    
                    // if v is in priority queue and weight < distance of v
                    if (!visited[v] && w < dist[v]) {  
                        dist[v] = w;        // distance of v = weight(u,v)
                        parent[v] = u;      // parent of v = u
                        pq.add(new Edge(v, w));     // add the updated to the priority queue
                    }
                }
            }
            int sum = 0;
            
            // prints the output
            for (int i = 1; i < n; i++) {
                sum += dist[i];
                System.out.printf("Edge %d-%d has a weight of %d\n", parent[i], i, dist[i]);
            }
            System.out.println("MST = " + sum);
        }
        sc.close();
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int weight;
    
    // constructor
    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
 
}
