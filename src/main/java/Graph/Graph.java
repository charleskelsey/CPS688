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

public class Graph {
    //adjacency list
    private Map<Integer, List<Integer>> adjList;
    
    //constructor
    public Graph(int n) {
        this.adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            this.adjList.put(i, new LinkedList<Integer>());
        }
    }
    
    //add an edge between two vertices
    public void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
    
    //compute degree of a vertex
    public int degreeVertex(int a) {
        return adjList.get(a).size();
    }
    
    //print adjacent vertices of a vertex
    public void printAdjVertices(int a) {
        List<Integer> adjVertices = adjList.get(a);
        for (int i = 0; i < adjVertices.size(); i++) {
            System.out.print(adjVertices.get(i) + " ");
        }
        System.out.println();
    }
    
    //breadth-first search
    public void bfs(int source) {
        //mark all vertices as unvisited
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < adjList.size(); i++) {
            visited.add(i);
        }
 
        //create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
 
        //mark source as visited
        visited.remove(source);
 
        //run BFS
        while (!queue.isEmpty()) {
            //dequeue a vertex from queue
            int vertex = queue.poll();
            System.out.print(vertex + " ");
 
            //get all adjacent vertices of the dequeued vertex
            List<Integer> adjVertices = adjList.get(vertex);
            for (int i = 0; i < adjVertices.size(); i++) {
                int adjVertex = adjVertices.get(i);
 
                //if the adjacent vertex is not visited, mark it visited and enqueue it
                if (visited.contains(adjVertex)) {
                    visited.remove(adjVertex);
                    queue.add(adjVertex);
                }
            }
        }
        System.out.println();
    }
    
    //depth-first search
    public void dfs(int source) {
        //mark all vertices as unvisited
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < adjList.size(); i++) {
            visited.add(i);
        }
 
        //create a stack for DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
 
        //mark source as visited
        visited.remove(source);
 
        //run DFS
        while (!stack.isEmpty()) {
            //pop a vertex from stack
            int vertex = stack.pop();
            System.out.print(vertex + " ");
 
            //get all adjacent vertices of the popped vertex
            List<Integer> adjVertices = adjList.get(vertex);
            for (int i = 0; i < adjVertices.size(); i++) {
                int adjVertex = adjVertices.get(i);
 
                //if the adjacent vertex is not visited, mark it visited and push it
                if (visited.contains(adjVertex)) {
                    visited.remove(adjVertex);
                    stack.push(adjVertex);
                }
            }
        }
        System.out.println();
    }
}
