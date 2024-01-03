//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int singleElement(int[] arr , int N) 
    {
        // code here
        int tn = -1, tnp1 = 0, tnp2 = 0;
        for(int i=0;i<arr.length;i++) 
        {
            int cwtn = arr[i] & tn;
            int cwtnp1 = arr[i] & tnp1;
            int cwtnp2 = arr[i] & tnp2;
            
            tn = tn & (~cwtn);
            tnp1 = tnp1 | cwtn;
            
            tnp1 = tnp1 & (~cwtnp1);
            tnp2 = tnp2 | cwtnp1;
            
            tnp2 = tnp2 & (~cwtnp2);
            tn = tn | cwtnp2;
            
        }
        return tnp1;
    }
}