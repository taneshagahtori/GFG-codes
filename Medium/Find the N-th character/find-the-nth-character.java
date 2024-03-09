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
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        StringBuilder str = new StringBuilder(s);
        StringBuilder temp;
        for(int i=0; i<r; i++){
            temp = new StringBuilder();
            for(int j=0; j<=n && j<str.length() && temp.length()<=n; j++){
                if(str.charAt(j)=='0'){
                    temp.append("01");
                }else{
                    temp.append("10");
                }
            }
            str = temp;
        }
        return str.charAt(n);
    }
}