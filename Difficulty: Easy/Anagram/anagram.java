//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean areAnagrams(String a, String b) {
        if(a.length()!=b.length()) return false;
       int[] arr=new int[26];
       for(char ch:a.toCharArray()) arr[ch-'a']++;
       for(char ch:b.toCharArray()) arr[ch-'a']--;
       for(int count:arr)  if(count!=0) return false;
       return true;
    }
}