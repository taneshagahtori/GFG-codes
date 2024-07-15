//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution
{
    public static long merge(long arr[],long low,long mid,long high){
        ArrayList<Long> temp = new ArrayList<Long>();
        long left=low;
        long right = mid+1;
        long count=0;
        while(left<=mid && right<=high){
            if(arr[(int)left]<=arr[(int)right])
            {
                temp.add(arr[(int)left]);
                left++;
            }
            else{
                temp.add(arr[(int)right]);
                count+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid)
        {
            temp.add(arr[(int)left]);
            left++;
                
        }
        while(right<=high)
        {
            temp.add(arr[(int)right]);
            right++;
        }
         
        for(int i=(int)low;i<=high;i++){
            arr[i]=temp.get(i-(int)low);
            
        } 
        return count;
        
    }

    static long mergeSort(long [] arr,long low,long high){
        long count=0;
        if(low>=high) return count;
        long mid=(low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr,0,N-1);
    }
}