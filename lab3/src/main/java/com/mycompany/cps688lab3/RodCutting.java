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
public class RodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // length of the rod
        int[] prices = new int[n+1]; // prices[0] is not used
        
        // scanning all prices and put them in the prices array
        for (int i = 1; i <= n; i++) {
            prices[i] = sc.nextInt();
        }
        
        // an array r of size n+1 to store the maximum revenue for each 
        // rod length from 0 to n.
        int[] r = new int[n+1]; // r[0] is 0 by default
        for (int i = 1; i <= n; i++) {  // loop through each rod length i from 1 to n.
            // For each rod length i, compute the maximum revenue q that 
            // can be obtained by trying all possible cuts.
            int q = 0;
            
            // To do this, we loop through all possible cut positions j from 1 to i 
            // and compute the revenue prices[j] + r[i-j] that can be obtained by cutting 
            // the rod at position j and selling the two resulting pieces 
            // (one of length j and the other of length i-j). 
            for (int j = 1; j <= i; j++) {
                // We take the maximum of all such revenues to obtain q.
                q = Math.max(q, prices[j] + r[i-j]);
            }
            
            // Set r[i] to q.
            r[i] = q;
        }
        
        // Once the loop finishes, the maximum revenue for the original rod length 
        // n is stored in r[n], which we print out.
        System.out.println(r[n]);
        sc.close();
    }
}
