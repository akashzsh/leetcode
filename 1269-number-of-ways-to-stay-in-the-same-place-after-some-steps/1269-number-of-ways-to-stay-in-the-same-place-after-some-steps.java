class Solution {
    int mod = 1000000007;
    
    private int move(int idx, int steps, int len, int[][] dp) {
        if (idx < 0 || idx >= len) return 0;
        if (steps == 0) {
            if (idx == 0) return 1;
            return 0;
        }
        if (dp[idx][steps] != -1) return dp[idx][steps];
        int ans = move(idx, steps - 1, len, dp);
        ans = (ans + move(idx - 1, steps - 1, len, dp)) % mod;
        ans = (ans + move(idx + 1, steps - 1, len, dp)) % mod;
        return dp[idx][steps] = ans;
    }
    
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return move(0, steps, arrLen, dp);
    }
}