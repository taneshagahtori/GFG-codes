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
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length();
        int k = pat.length();
        
        for(int i = 0;i<n-k+1;i++){
            int flag = 1;
            if(txt.charAt(i)!=pat.charAt(0)) continue; //this will reduce extra time 
            for(int j = i;j<(i+k);j++){
                if(txt.charAt(j)!=pat.charAt(j-i)){
                    flag = 0;
                    break;
                }
            }
            if(flag==1){
                res.add(i+1);
            }
        }
        return res;
    }
}