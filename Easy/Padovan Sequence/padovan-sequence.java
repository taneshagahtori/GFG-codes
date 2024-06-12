//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        int mod=1000000007;
        int a=1,b=1,c=1,d=0;
        if(n<=2)
        return 1;
        else{
            while(n>2){
           d=(a+b)%mod;
           a=b%mod;
           b=c%mod;
           c=d;
           n--;
            }
            return d;
        }
    }
    
}
