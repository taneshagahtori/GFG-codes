//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        // Add all the rope lengths to the priority queue.
        for (long rope : arr) {
            pq.add(rope);
        }
        
        long totalCost = 0;
        
        // While more than one rope is left in the heap.
        while (pq.size() > 1) {
            // Get the two smallest ropes.
            long first = pq.poll();
            long second = pq.poll();
            
            // The cost of connecting the two ropes.
            long cost = first + second;
            
            // Add this cost to the total cost.
            totalCost += cost;
            
            // Insert the new combined rope back into the heap.
            pq.add(cost);
        }
        
        // Return the total cost.
        return totalCost;
    }
}
