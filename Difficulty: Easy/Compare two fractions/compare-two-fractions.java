//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        
        int firstSlashIdx = str.indexOf('/');
        int secondSlashIdx = str.indexOf('/', firstSlashIdx + 1);
        int commaIdx = str.indexOf(',');
        int num1 = Integer.parseInt(str.substring(0,firstSlashIdx));
        int den1 = Integer.parseInt(str.substring(firstSlashIdx+1,commaIdx));
        int num2 = Integer.parseInt(str.substring(commaIdx+2,secondSlashIdx));
        int den2 = Integer.parseInt(str.substring(secondSlashIdx+1,str.length()));
        
        double val1 = (double)num1/den1;
        double val2 = (double)num2/den2;
        if(val1 == val2) return "equal";
        else if(val1 > val2){
            return str.substring(0,commaIdx);
        }
        else{
            return str.substring(commaIdx+2,str.length());
        }
    }
}