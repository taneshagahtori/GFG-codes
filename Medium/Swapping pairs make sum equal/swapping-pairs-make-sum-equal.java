//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        Arrays.sort(A);Arrays.sort(B);
        long aSum=0,bSum=0;
        int x=0,y=0;
        for(long i:A) aSum+=i;
        for(long i:B) bSum+=i;
        while(x<n && y<m){
            long aTemp=aSum-A[x]+B[y],bTemp=bSum-B[y]+A[x];
            if(aTemp==bTemp) return 1;
            else if(aTemp<bTemp) y++;
            else x++;
        }
        return -1;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends