//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int a: arr)map.put(a, map.getOrDefault(a,0)+1);
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int rest=target-arr[i];
            if(rest!=arr[i] && map.containsKey(rest)==true){
                return true;
            }
            if(rest==arr[i] && map.get(arr[i])>1) return true;
        }
        
        return false;
    }
}