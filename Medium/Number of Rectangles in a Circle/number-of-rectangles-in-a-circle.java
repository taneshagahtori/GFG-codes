//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int rectangles = 0;

        int diameter = 2 * r;
        int diameterSquare = diameter * diameter;

        for (int a = 1; a < 2 * r; a++) {
            for (int b = 1; b < 2 * r; b++) {
                int diagonalLengthSquare = a * a + b * b;
                    if (diagonalLengthSquare <= diameterSquare) {
                rectangles++;
                    }
                }
            }

        return rectangles;

    }
};