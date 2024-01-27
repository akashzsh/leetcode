class Solution {
    long MOD = 1_000_000_007;
    
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            long sum = 1;
            for (int j = 1; j <= k; j++) {
                sum = sum + dp[i - 1][j];
                if (j >= i) {
                    sum = sum - dp[i - 1][j - i];
                }
                dp[i][j] = (int)(sum % MOD);
            }
        }
        return dp[n][k];
    }
}