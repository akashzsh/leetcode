class Solution {
    private int breakInteger(int n, int[] dp) {
        if (n <= 3) return n;
        if (dp[n] != 0) return dp[n];
        int ans = n;
        for (int i = 2; i < n; i++) {
            ans = Math.max(ans, i * breakInteger(n - i, dp));
        }
        return dp[n] = ans;
    }
    
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        return breakInteger(n, dp);
    }
}