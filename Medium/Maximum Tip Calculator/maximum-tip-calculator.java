//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static class TipIndex{
        int diff;
        int index;
        
        TipIndex(int a, int b, int i){
            diff = a-b;
            index = i;
        }
    }
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        
        ArrayList<TipIndex> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new TipIndex(arr[i], brr[i], i));
        }
        
        Collections.sort(al, new Comparator<TipIndex>() {
            @Override
            public int compare(TipIndex t1, TipIndex t2) {
                // Sorting in descending order
                return Integer.compare(t2.diff, t1.diff);
            }
        });
        long tip1=0, tip2=0, tip3=0;
        
        for(int i=0;i<n-y;i++){
            tip1  =  tip1 + (long)(arr[al.get(i).index]);
        }
        for(int i=n-y;i<x;i++){
            if(al.get(i).diff>=0){
                tip2 = tip2 + (long)(arr[al.get(i).index]);
            }
            else{
                tip2= tip2+(long)(brr[al.get(i).index]);
            }
        }
        for(int i=x;i<n;i++){
            tip3  = tip3+ (long)(brr[al.get(i).index]);
        }

        
        return (long)(tip1+tip2+tip3);
    }
}