//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
         int n = arr.length;
        // calculate left maximum boundary
        int leftmaxBoundary[] = new int[n];
        leftmaxBoundary[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftmaxBoundary[i] = Math.max(arr[i], leftmaxBoundary[i - 1]);
        }
        // calculate right max boundary
        int rightMaxBoundary[] = new int[n];
        rightMaxBoundary[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxBoundary[i] = Math.max(arr[i], rightMaxBoundary[i + 1]);

        }
        int trappedwater = 0;
        // loop
        // water level=minimum(leftmaximum boundary,right max boundary)
        for (int i = 0; i < n; i++) {
            // to find the water level
            int waterLevel = Math.min(leftmaxBoundary[i], rightMaxBoundary[i]);
            // trapped water=====(Water level-height)*width
            trappedwater += (waterLevel - arr[i]) * 1;

        }
        return trappedwater;
    }
}