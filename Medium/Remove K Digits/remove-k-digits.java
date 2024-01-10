//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String s, int k) {
        // code here
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String newWord;

        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > num){
                stack.pop();
                k--;
            }
            if(stack.isEmpty() && num == '0')
                continue;
            stack.push(num);
        }

        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        
        if(stack.isEmpty())
            return "0";
        
        while(!stack.isEmpty()){
            sb.append(stack.peek());
            stack.pop();
        }

        newWord = sb.reverse().toString();
        return newWord;
    }
}