//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
     static int slove(String patt, String s,int i,int j,int dp[][]){
        //base case 
        if(i<0 && j<0){
            return 1;
        }
        if(i<0 && j>=0){
            return 0;
        }
        if(i>=0 && j<0){
            for(int k=0;k<=i;k++){
                if(patt.charAt(k)!='*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        //match 
        if(patt.charAt(i)==s.charAt(j) || patt.charAt(i)=='?'){
            return dp[i][j]=slove(patt, s, i-1,j-1,dp);
        }
        else if(patt.charAt(i)=='*'){
            return dp[i][j]=(slove(patt,s,i,j-1,dp) + slove(patt,s,i-1,j,dp));
        }
        else{
            return 0;
        }
        
    }
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        int p=pattern.length()-1;
        int sl=str.length()-1;
        int dp[][]=new int[p+1][sl+1];
        for(int l=0;l<=p;l++){
            for(int m=0;m<=sl;m++){
                dp[l][m]=-1;
            }
        }
        int flag=slove(pattern,str,p,sl,dp);
       if(flag>0){
           return 1;
       }
       return 0;
    }
}
