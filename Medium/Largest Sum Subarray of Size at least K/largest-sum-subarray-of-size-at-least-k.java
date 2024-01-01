//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long arr[], long n, long k) {

 

 int[] maxSubArrSum = new int[arr.length];

 int sum = 0;

 

 for (int i = 0; i < arr.length; i++) {

 sum += arr[i];

 maxSubArrSum[i] = sum;

 if (sum < 0)

 sum = 0;

 }

 

 long exactKSum = 0;

 long max = Long.MIN_VALUE;

 for (int i = 0; i < k; i++) {

 exactKSum += arr[i];

 }

 

 if (exactKSum > max)

 max = exactKSum;

 for (int i = (int) k; i < arr.length; i++) {

 exactKSum += arr[i] - arr[i - (int) k];

 long atleastKSum = exactKSum + maxSubArrSum[i - (int) k];

 if (exactKSum > max)

 max = exactKSum;

 if (atleastKSum > max)

 max = atleastKSum;

 }

 

 return max;

 }
}