class Solution {
    public int numWays(int steps, int n) {
        int mod = 1000000007;
        n = Math.min(n, steps);
        int[][] dp = new int[n][steps + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= steps; j++) {
            for (int idx = n - 1; idx >= 0; idx--) {
                int ans = dp[idx][j - 1];
                if (idx > 0) ans = (ans + dp[idx - 1][j - 1]) % mod;
                if (idx < n - 1) ans = (ans + dp[idx + 1][j - 1]) % mod;
                dp[idx][j] = ans;
            }
        }
        return dp[0][steps];
    }
}