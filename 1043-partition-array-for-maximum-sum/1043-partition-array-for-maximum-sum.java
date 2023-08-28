class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int ans = 0, max = 0, len = 0;
            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                max = Math.max(max, nums[j]);
                int cur = len * max + dp[j + 1];
                ans = Math.max(ans, cur);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}