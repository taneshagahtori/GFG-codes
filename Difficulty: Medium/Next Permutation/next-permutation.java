//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        int idx = -1;
        int n = arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            reverse(0,arr,n);
            return;
        }
        for(int i=n-1;i>idx;i--){
            if(arr[idx]<arr[i]){
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        reverse(idx+1,arr,n);
    }
    void reverse(int idx, int[] arr, int n){
        int j=0;
        for(int i=idx;i<(idx+n)/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-j-1];
            arr[n-j-1] = temp;
            j++;
        }
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends