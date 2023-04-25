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
public class Problem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();       // scans the number of candies present in the shop
        int val[] = new int[n];     // create an integer array for the sentimental values of the candies
        int wt[] = new int[n];      // create an integer array for the weight of the candies
        
        for (int i=0; i<n; i++) {   // a for loop to scan the sentimental values of the candies
            val[i] = sc.nextInt();  // and place it in the integer array for values
        }
        
        for(int i=0; i<n; i++) {    // a for loop to scan the weight of the candies
            wt[i] = sc.nextInt();   // and place it in the integer array for weights
        }
        
        int W = sc.nextInt();       // scans the maximum weight that can be carried by the bag
        
        int dp[][] = new int[n+1][W+1];
        for (int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++){
                if (wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];  // go down one row in the 2d array
                } else {
                    // value(w,i) = max{value(w-wi,i-1)+vi,value(w,i-1)}
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }
            }
        }
        System.out.println(dp[n][W]);   // prints out the highest sentimental aggregated value
    }
    
}
