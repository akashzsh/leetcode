//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int nums[]) {
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1)
                        dp[day][buy][cap] = Math.max(-nums[day] + dp[day + 1][0][cap], dp[day + 1][1][cap]);
                    else
                        dp[day][buy][cap] = Math.max(nums[day] + dp[day + 1][1][cap - 1], dp[day + 1][0][cap]);
                }
            }
        }
        return dp[0][1][k];
    }
}