//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String arr[] = read.readLine().trim().split("\\s+");
            double perimeter = Double.parseDouble(arr[0]);
            double area = Double.parseDouble(arr[1]);

            Solution ob = new Solution();
            double ans = ob.maxVolume(perimeter, area);
            System.out.println(String.format("%.2f", ans));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    double maxVolume(double perimeter, double area) {
        // Calculation of formula to find the maximum volume
        double part1 = perimeter - Math.sqrt(Math.pow(perimeter, 2) - (24 * area));
        double term = Math.pow(part1 / 12, 2);
        double height = (perimeter / 4) - (2 * (part1 / 12));
        double ans = term * height;

        // Returning the maximum volume
        return ans;
    }
}