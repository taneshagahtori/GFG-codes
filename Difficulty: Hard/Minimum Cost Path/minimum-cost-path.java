//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;

        int[][] minCost = new int[n][n];
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        minCost[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            // Get the cell with the lowest cost
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];

            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = cost + grid[newX][newY];
                    
                    if (newCost < minCost[newX][newY]) {
                        minCost[newX][newY] = newCost;
                        pq.offer(new int[]{newX, newY, newCost});
                    }
                }
            }
        }

        return -1;
    }
}
