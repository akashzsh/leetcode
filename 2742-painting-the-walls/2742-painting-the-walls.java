class Solution {
    private int solve(int i, int[] cost, int[] time, int rem, int[][] dp) {
        if (rem <= 0) return 0;
        if (i == cost.length) return (int) 10e8;
        if (dp[i][rem] != -1) return dp[i][rem];
        int paint = cost[i] + solve(i + 1, cost, time, rem - 1 - time[i], dp);
        int notPaint = 0 + solve(i + 1, cost, time, rem, dp);
        return dp[i][rem] = Math.min(paint, notPaint);
    }
    
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] cur : dp) Arrays.fill(cur, -1);
        return solve(0, cost, time, cost.length, dp);
    }
}