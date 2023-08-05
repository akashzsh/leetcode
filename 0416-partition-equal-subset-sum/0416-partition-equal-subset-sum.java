class Solution {
    public boolean solve(int ind, int k, int[] nums, int n) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (nums[0] <= k) dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (nums[i] <= j) pick = dp[i - 1][j - nums[i]];
                dp[i][j] = pick | notPick;
            }
        }
        return dp[n - 1][k];
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;
        for (int i = 0; i < len; i++) sum += nums[i];
        if (sum % 2 != 0) return false;
        return solve(0, sum / 2, nums, len);
    }
}