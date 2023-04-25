/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author charl
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        //create graph
        Graph graph = new Graph(n);
        
        //add edges
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.addEdge(a, b);
        }
        
        //print adjacent vertices
        System.out.println("Adjacent Vertices:");
        for (int j = 0; j < n; j++) {
            System.out.print(j + ": ");
            graph.printAdjVertices(j);
        }
        
        //print vertices using BFS
        System.out.println("BFS:");
        graph.bfs(0);
        
        //print vertices using DFS
        System.out.println("DFS:");
        graph.dfs(0);
    }
}
