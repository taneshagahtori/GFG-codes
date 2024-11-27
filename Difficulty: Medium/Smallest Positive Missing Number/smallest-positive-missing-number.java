//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int missingNumber(int[] arr) {
        // Your code here
        HashSet<Integer> map = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE; int res=0;
        for(int ar:arr){
            min = Math.min(ar,min);
            max = Math.max(ar,max);
            map.add(ar);
        }
        // System.out.println (max+" "+min);
        for(int i = 1;i<max;i++){
            if(!map.contains(i) && i>0){
                
                return i;
            }
        }
        if(min>1){
            res = 1;
        }else{
            if(max >= 0){
            res = max+1;
            }else{
                res = 1;
            }
        }
        return res;
    }
}
