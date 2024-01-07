//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int sum = 0;
        for(int i = 0; i<N; i++) sum+=arr[i];
        return helper(arr,arr[N-1],sum,K,-1);
    }
    public static int helper(int[] arr, int start , int end , int k, int ans){
        if(start <= end){
            int mid = start + (end - start)/2;
            if(isPossible(arr,k,mid)){
                ans = mid;
                return helper(arr,start , mid-1, k , ans);
            }else{
                return helper(arr, mid+1, end, k, ans);
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] arr, int k,int mid){
        int kcount = 1,subArrsum = 0;
        for(int i = 0; i<arr.length; i++){
            if(subArrsum + arr[i] <= mid){
                subArrsum+=arr[i];
            }else{
                kcount++;
                if(kcount>k || arr[i] > mid) return false;
                
                subArrsum = arr[i];
            }
        }
        return true;
    }
};