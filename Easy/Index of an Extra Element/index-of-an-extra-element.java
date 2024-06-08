//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
       int first1=0;
       int last1=arr1.length-1;
     
       int sum1=sum(arr1);
       int sum2=sum(arr2);
       int val=sum1-sum2;
       while(first1<=last1){
           int mid= (first1+last1)/2;
          
           if(arr1[mid]==val){
               return mid;
           }
           else if(val>arr1[mid]){
               first1=mid+1;
           }
           else{
               last1=mid-1;
           }
       }
       
       return -1;
    }
    public static int sum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
}