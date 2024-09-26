//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {

    public int maxStep(int arr[]) {
        // Initializing variables to keep track of max steps and current steps
        int maxSteps = 0;
        int currentSteps = 0;

        // Looping through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Checking if current building is taller than the previous one
            if (arr[i] > arr[i - 1]) {
                currentSteps++; // Increase the count of current steps
            } else {
                // Reseting the current steps count if the altitude decreases or stays the same
                currentSteps = 0;
            }
            // Updating max steps if current steps is greater
            maxSteps = Math.max(maxSteps, currentSteps);
        }

        //the maximum number of consecutive steps
        return maxSteps;
    }
}
