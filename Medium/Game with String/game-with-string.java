//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
       HashMap<Character,Integer> map=new HashMap<>();
       for(char c:s.toCharArray()){
           map.put(c,map.getOrDefault(c,0)+1);
       }
       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
       
       for(Map.Entry<Character,Integer> entry:map.entrySet()){
           pq.offer(entry.getValue());
       }
       int index=0;
       while(index<k){
           int val=pq.peek();
           pq.remove();
           pq.offer(val-1);
           index++;
       }
       int res=0;
       while(!pq.isEmpty()){
           int top=pq.peek();
           res+=top*top;
           pq.remove();
       }
       return res;
    }
}