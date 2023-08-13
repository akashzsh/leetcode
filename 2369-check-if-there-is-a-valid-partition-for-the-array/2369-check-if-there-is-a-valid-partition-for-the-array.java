class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int index = 0; index < n; index++) {
            int dpIndex = index + 1;
            if (index > 0 && nums[index] == nums[index - 1]) {
                dp[dpIndex] |= dp[dpIndex - 2];
            }
            if (index > 1 && nums[index] == nums[index - 1] && nums[index] == nums[index - 2]) {
                dp[dpIndex] |= dp[dpIndex - 3];
            }
            if (index > 1 && nums[index] == nums[index - 1] + 1 && nums[index - 1] == nums[index - 2] + 1) {
                dp[dpIndex] |= dp[dpIndex - 3];
            }
        }
        return dp[n];
    }
}