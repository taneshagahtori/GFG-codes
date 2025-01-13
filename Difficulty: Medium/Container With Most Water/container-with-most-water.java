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


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        int left = 0; // Pointer at the start of the array
        int right = arr.length - 1; // Pointer at the end of the array
        int maxArea = 0; // Variable to store the maximum area

        while (left < right) {
            // Calculate the width and height of the container
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);

            // Update the maximum area
            maxArea = Math.max(maxArea, width * height);

            // Move the pointer pointing to the shorter line
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}