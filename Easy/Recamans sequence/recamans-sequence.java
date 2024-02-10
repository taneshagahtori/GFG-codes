//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   static  Set<Integer> set;
    static ArrayList<Integer>ans;
    static int helper(int n)
    {
        if(n==0)
        {
            ans.add(0);
            set.add(0);
            return 0;
        }
        int ans1= helper(n-1)-n;
    
        if(ans1>0 && !set.contains(ans1)){
            set.add(ans1);
            ans.add(ans1);
            return ans1;
        }
        else{
            int result = ans1 + 2*n;
                set.add(result);
                ans.add(result);
                return result;
        }
    }
    static ArrayList<Integer> recamanSequence(int n){
      set=new HashSet<>();
      ans=new ArrayList<>();
      helper(n);
       return ans;
       
    }
}