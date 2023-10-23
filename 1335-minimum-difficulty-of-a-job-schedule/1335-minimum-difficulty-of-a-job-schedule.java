class Solution {
    private int solve(int idx, int days, int[] jobDifficulty, int n, int[][] dp) {
        if (days == 1) {
            int max = jobDifficulty[idx];
            for (int i = idx; i < n; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }
        
        if (dp[idx][days] != -1) return dp[idx][days];
        
        int maxD = jobDifficulty[idx], cur = 0, res = Integer.MAX_VALUE;
        for (int i = idx; i <= n - days; i++) {
            maxD = Math.max(maxD, jobDifficulty[i]);
            cur = maxD + solve(i + 1, days - 1, jobDifficulty, n, dp);
            res = Math.min(res, cur);
        }
        
        return dp[idx][days] = res;
    }
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[n + 1][d + 1];
        for (int[] cur : dp) Arrays.fill(cur, -1);
        if (d > n) return -1;
        return solve(0, d, jobDifficulty, n, dp);
    }
}