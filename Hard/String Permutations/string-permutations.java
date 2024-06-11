//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> res=new ArrayList<>();
        char arr[]=S.toCharArray();
        permutation(arr, res, 0);
        Collections.sort(res);
        return res;
        
    }
    public void permutation(char arr[], ArrayList<String> a, int index){
        if(index==arr.length-1){
            String str=String.valueOf(arr);
            a.add(str);
            return;
        }
        for(int i=index; i<arr.length; i++){
            swap(arr,index, i);
            permutation(arr, a, index+1);
            swap(arr, i, index);
        }
    }
	public void swap(char arr[], int a, int b){
	    char temp=arr[a];
	    arr[a]=arr[b];
	    arr[b]=temp;
	}
}
