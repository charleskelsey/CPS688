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
public class LIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sequence: ");
        
        // takes the sequqnce as input from the user and converts it to an integer array
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int n = arr.length;     // n is the length of the sequence
        int[] dp = new int[n];      // dp array is used to store the length of the LIS ending at each index
        int[] prev = new int[n];    // prev array is used to store the index of the previous element in the LIS
        
        // set all the elements of the dp array to 1,
        // as each element itself forms a subsequence of length 1
        Arrays.fill(dp, 1);
        // the prev array is initialized to -1, indicating that each element has
        // no previous element in the LIS
        Arrays.fill(prev, -1);
        
        // this part iterates over each element of the sequence from left to right
        // for each element, it compares it with all the previous elements in the sequence
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // if the current element is greater than the previous element and
                // the LIS ending at the previous element plus 1 is greater than the current LIS length
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    // then update the dp array and prev array
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // keep track of the of the index of the max element in the dp array
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // this part finds the index of the max element in the dp array, which corresonds
        // to the end of the LIS. It then uses the prev array to construct the LIS 
        // by pushing the elements onto a stack in reverse order. Finally, it prints
        // the length of the LIS and the LIS itself 
        int lisLength = dp[maxIndex];
        System.out.println("LIS = " + lisLength);
        System.out.print("LIS is: ");
        Stack<Integer> stack = new Stack<>();
        while (maxIndex != -1) {
            stack.push(arr[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
}
