//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    Boolean isPalindrome(int arr[],int n){
        int l = 0,h = n-1;
        while(l<h){
            if(arr[l]!=arr[h]) return false;
            l++;
            h--;
        }
    return true;
    }
    void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    void TransposeArr(int[][] arr, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) { 
                swap(arr, i, j);
            }
        }
    }

    
    public String pattern(int[][] arr) {
       int len = arr[0].length;
       
       for(int i=0; i<len; i++){
          if(isPalindrome(arr[i],len)){
              return i+" R";
          }
       }
       
       TransposeArr(arr,len);
       
       for(int i=0; i<len; i++){
          if(isPalindrome(arr[i],len)){
              return i+" C";
          }
       }
     return "-1";
    }
}