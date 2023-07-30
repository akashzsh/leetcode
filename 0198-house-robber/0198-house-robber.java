class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            int pick;
            if (i - 2 >= 0) pick = nums[i] + dp[i - 2];
            else pick = nums[i];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}