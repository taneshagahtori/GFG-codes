//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> dups = new ArrayList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        for(int x: arr) {
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }
        for(Map.Entry<Integer, Integer> ent : mp.entrySet()) {
            if(ent.getValue() > 1)
                dups.add(ent.getKey());
        }
        if(dups.isEmpty())
            dups.add(-1);
        
        return dups;
    }
}
