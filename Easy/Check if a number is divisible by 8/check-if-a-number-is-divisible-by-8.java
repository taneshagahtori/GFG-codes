//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        /*if the last three numbers are 0 or divisible by 
         8 then whole number is divisible by 8*/

        s="00"+s;
        int n=Integer.parseInt(s.substring(s.length()-3));
        return (n==0 || n%8==0)?1:-1;   
    }
}