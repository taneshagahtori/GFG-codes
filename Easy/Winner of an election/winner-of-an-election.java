//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    public static String[] winner(String arr[], int n){
       HashMap<String,Integer>map = new HashMap();
       int max = 0;
       String ans = "";
       for(String x:arr){
           map.put(x,map.getOrDefault(x,0)+1);
           int t = map.get(x);
           if(t==max && x.compareTo(ans)<0){
                ans = x;
           }
           else if(t>max){
               max = t;
               ans = x;
           }
       }
       return new String[]{ans,max+""};
    }
}

