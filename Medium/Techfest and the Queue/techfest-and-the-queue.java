//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long sum=0;
        while(a<=b && (b-a)<=100000){
            sum+=factors(a);
            a++;
        }
        return sum;
    }
    public static long factors(long num){
        long factorSum=0;
        if(num<=1) return 0;
        while(num%2==0){
            factorSum++;
            num/=2;
        }
         for(long i=3;i<=Math.sqrt(num);i+=2){
                while(num%i==0 && num>0){
                        factorSum++;
                        num/=i;
                    }
                }
        if(num>2) 
            factorSum++;
        return factorSum;
    }
    
}
