//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code hereif 
        PriorityQueue<Job> pq=new PriorityQueue<>((a,b)->b.profit-a.profit);
        int[] deadline=new int[n+1];
        Arrays.fill(deadline,-1);
        for (Job j:arr) pq.add(j);
    
        int[] res=new int[2];
        int ress=0;
        int ctn=0;
        while (!pq.isEmpty()){
            Job cur=pq.poll();
            int ind=cur.deadline;
            while (ind>=0 && deadline[ind]!=-1){
        
                ind--;
            }
            if (ind>0 && deadline[ind]==-1){
               deadline[ind]=cur.id;
                ress+=cur.profit;
                ctn++;
            }
        }
        
        res[0]=ctn;
        res[1]=ress;
        return res;
        
        
    }
}
/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/