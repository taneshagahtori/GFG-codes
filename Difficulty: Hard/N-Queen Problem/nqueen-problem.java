//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int[] board = new int[n]; // To store the position of queens
        placeQueens(0, board, results, n);
        return results;
    }

    // Helper method to place queens on the board
    private void placeQueens(int row, int[] board, ArrayList<ArrayList<Integer>> results, int n) {
        if (row == n) {
            results.add(createBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board)) {
                board[row] = col;
                placeQueens(row + 1, board, results, n);
            }
        }
    }

    // Method to check if the queen placement is valid
    private boolean isValid(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            int prevCol = board[i];
            // Check if queens are in the same column or on the same diagonal
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Method to create the board configuration as a list of integers
    private ArrayList<Integer> createBoard(int[] board) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(board[i] + 1); // Convert 0-based index to 1-based index
        }
        return result;
    }
}
