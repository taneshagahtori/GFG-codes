//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends


class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer, Integer> hm=new HashMap<>();
        int mdist=0;
        
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i])){
                int dist=i-hm.get(arr[i]);
                mdist=Math.max(mdist, dist);
            }
            else{
                hm.put(arr[i], i);
            }
        }
        return mdist;
    }
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends