/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cps688lab3;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();   // number of vertices
            int e = sc.nextInt();   // number of edges

            Graph g = new Graph(n);     // create a graph

            // add the directed edges
            for (int i = 0; i < e; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                g.addEdge(v, w);
            }

            // checks if the graph is stringly connected, then print "yes"
            // else pirnt "no"
            if (g.isStronglyConnected()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
