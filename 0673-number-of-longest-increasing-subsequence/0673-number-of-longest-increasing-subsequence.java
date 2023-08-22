class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxi = 1, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (nums[i] > nums[j] && dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) ans += cnt[i];
        }
        return ans;
    }
}