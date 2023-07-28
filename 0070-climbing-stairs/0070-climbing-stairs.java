class Solution {
    public int solve(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }
    
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}