//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
         StringBuilder s=new StringBuilder(text);
       ArrayList<Integer> a=new ArrayList<>();
       int ans=0;
       int co=0;
       while(ans!=-1)
       {
           ans=s.indexOf(pattern,ans);
           if(ans!=-1)
           {
               a.add(ans+co+1);
               s.deleteCharAt(ans);
               co++;
           }


       }

        return a;
    }
}