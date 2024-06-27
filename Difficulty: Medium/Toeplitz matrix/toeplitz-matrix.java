//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToepliz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean isToepliz(int mat[][]) {
        int n=mat.length;
        int m=mat[0].length;
       for(int i=1;i<n;i++){
           for(int j=1;j<m;j++){
               if(mat[i][j]!=mat[i-1][j-1])return false;
           }
       }
       return true;
    }   
}
