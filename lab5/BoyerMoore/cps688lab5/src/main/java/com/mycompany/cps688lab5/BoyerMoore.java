/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cps688lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author charl
 */
public class BoyerMoore {
    
    private final int R;     // the radix
    private int[] right;     // the rightmost occurrences of characters in the pattern
    private String pat;      // the pattern
    
    public BoyerMoore(String pat) {
        this.R = 256;  // extended ASCII alphabet size
        this.pat = pat;

        // precompute the rightmost occurrences of characters in the pattern
        // creating the skip table
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;              // put -1 when not in pattern
        }
        for (int j = 0; j < pat.length(); j++) {
            right[pat.charAt(j)] = j;   // put the index number if in pattern
        }
    }
    
    public ArrayList<Integer> search(String txt) {
        ArrayList<Integer> indices = new ArrayList<>();
        int N = txt.length();       // the length of the text
        int M = pat.length();       // the length og the pattern
        int skip;
        for (int i = 0; i <= N-M; i += skip) {
            // the amount we shift the pattern to the right when we find a mismatch
            skip = 0;   // initialize skip to 0
            
            // This for loop starts from the right end of the pattern M - 1 and 
            // moves left to compare each character in the pattern with the corresponding character in txt
            for (int j = M-1; j>= 0; j--) {
                // If we find a mismatch, we calculate the amount to shift the pattern to the right
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    // Skip if we can, else just increment i by 1
                    // This prevents the possibility of backup when we have a mismatched 
                    // character in pattern, as denoted earlier.
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                    break;
                }
            }
            // If we don't find a mismatch, we have found an occurrence of the pattern in txt, 
            // so we return the index i of the first character in the pattern in txt
            if (skip == 0) {
                indices.add(i);
                skip = 1;
            }
        }
        return indices;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter the text: ");
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }

            System.out.print("Enter the pattern: ");
            String pattern = scanner.nextLine();
            
            BoyerMoore bm = new BoyerMoore(pattern);
            ArrayList<Integer> indices = bm.search(text);
            
            if (indices.isEmpty()) {
                System.out.println("Pattern not found");
            } else {
                System.out.print("Pattern " + pattern + " found at index");
                if (indices.size() > 1) {
                    System.out.print("es");
                }
                System.out.print(": ");
                for (int i = 0; i < indices.size(); i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(indices.get(i));
                }
                System.out.println();
            }
        }
    }
}
