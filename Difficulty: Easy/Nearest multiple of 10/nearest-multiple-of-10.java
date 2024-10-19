//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        StringBuilder solution = new StringBuilder(str);
        
        int n = str.length();
        
        if (str.charAt(n - 1) <= '5') {
            solution.setCharAt(n - 1, '0');
            return solution.toString();
        }
        
        solution.setCharAt(n - 1, '0');
        for (int i = n - 2; i >= 0; i--) {
            if ((char)(str.charAt(i) + 1) > '9') {
                solution.setCharAt(i, '0');
            } else {
                solution.setCharAt(i, (char)(str.charAt(i) + 1));
                return solution.toString();
            }
        }
        
        solution.insert(0, '1');
        return solution.toString();
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends