//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{   
    // Swap two elements in the array
    void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Push all zeros to the end of the array
    int[] pushZerosToEnd(int[] arr) 
    {
        int n = arr.length;
        int j = 0; // Pointer for non-zero elements
        
        // Traverse the array
        for (int i = 0; i < n; i++) 
        {
            if (arr[i] != 0) 
            {
                swap(arr, i, j); // Swap current non-zero element with the element at j
                j++;
            }
        }
        return arr;
    }
}