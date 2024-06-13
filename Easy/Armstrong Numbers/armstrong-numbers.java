//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        String s1 = "Yes";
        String s2 = "No";
        int k=n;
        int pal = 0;
        while(k>0)
        {
            int z = k%10;
            pal=pal+(z*z*z);
            k=k/10;
        }
        if(pal==n)
        {
            return s1;
        }
        return s2;
    }
}