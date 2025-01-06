//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer>list=new ArrayList<>();
        Arrays.sort(arr);
        int st=0;
        int ed=arr.length-1;
        int diff=Integer.MAX_VALUE;
        int[] a=new int[2];
        a[0]=-1;
        a[1]=-1;
        while(st<ed){
            int sum=arr[st]+arr[ed];
            if(Math.abs(target-sum)<diff){
            diff=Math.min(Math.abs(target-sum),diff);
            a[0]=arr[st];
            a[1]=arr[ed];
           
            }
            if(sum<target){
                st++;
            }
            else if(sum>target){
                ed--;
            }
            else{
            list.add(a[0]);
            list.add(a[1]);
                return list;
            }
            
    }
  if(a[0]!=-1 && a[1]!=-1){
     list.add(a[0]);
            list.add(a[1]);
      
} 
    
            return list;
            
}
    
}