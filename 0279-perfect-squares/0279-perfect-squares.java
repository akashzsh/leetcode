class Solution {
    int[] dp;
    
    private int solve(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (dp[n] != -1) return dp[n];
        
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int cnt = 1 + solve(n - i * i);
            res = Math.min(res, cnt);
        }
        return dp[n] = res;
    }
    
    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
}