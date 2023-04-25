/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps688lab2;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class NQueens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scans the input
        Scanner sc = new Scanner(System.in);
        System.out.print("Input:");
        int n = sc.nextInt();   //the matrix size
        
        int[][] board = new int[n][n];  //Create a 2d array for the board
        if (solveNQueens(board, 0, n)) {    //call the recursive function
            for (int i = 0; i < n; i++) {   //goes through the columns and rows
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");    //print 0 or 1
                }
                System.out.println();
            }
        } else {    //when there is no solution
            System.out.println("No solution");
        }
    }
    
    //A recurisve function that tries to place a queen in each column
    //starting from the leftmost column
    public static boolean solveNQueens(int[][] board, int col, int n) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            //check if it is safe to place the queen at position (i,col) then place it
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;
                
                //The recursive call passes the board and sets column to col+1
                if (solveNQueens(board, col + 1, n)) {
                    return true;
                }
                
                //If the recursive call returns false, we backtrack by resetting the entry to 0
                //backtrack if the condition above is false
                board[i][col] = 0;
            }
        }
        return false;   //when there is no solution return false
    }
    
    
    //This method checks if a queen can be placed in a given row and column
    //by checking for clashes with already placed queens
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        int i, j;
        for (i = 0; i < col; i++) {     //check every column
            if (board[row][i] == 1) {   //if there is a queen
                return false;           //not safe
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {    //check for right diagonals
            if (board[i][j] == 1) {                             //if there is a queen
                return false;                                   //not safe
            }
        }
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {     //check for left diagonals
            if (board[i][j] == 1) {                             //if there is a queen
                return false;                                   //not safe
            }
        }
        return true;    //else return safe
    }
    
}
