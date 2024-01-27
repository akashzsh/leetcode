class Solution {
    int MOD = 1_000_000_007;
    
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int inv = 0; inv <= Math.min(j, i - 1); inv++) {
                    dp[i][j] = (dp[i][j] % MOD + dp[i - 1][j - inv] % MOD) % MOD;
                }
            }
        }
        return dp[n][k];
    }
}