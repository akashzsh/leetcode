//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N][sum + 1];
        for (int i = 0; i < N; i++) dp[i][0] = true;
        if (arr[0] <= sum) dp[0][arr[0]] = true;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (arr[i] <= j) pick = dp[i - 1][j - arr[i]];
                dp[i][j] = pick | notPick;
            }
        }
        return dp[N - 1][sum];
    }
}