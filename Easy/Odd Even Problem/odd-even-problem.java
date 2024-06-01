//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        Hashtable<Character, Integer> freq = new Hashtable<>();
        int x = 0, y = 0;
        
        for (int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for (char c: freq.keySet()){
            if ((c + 1 - 'a')%2 == 1 && freq.get(c)%2 == 1)
                x += 1;
            else if ((c + 1 - 'a')%2 == 0 && freq.get(c)%2 == 0)
                y += 1;
        }
        
        return ((x+y)%2 == 1) ? "ODD" : "EVEN";
    }
}
