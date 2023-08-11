class Solution {
    private int count(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int notPick = 0 + count(index - 1, target, nums, dp);
        int pick = 0;
        if (nums[index] <= target)
            pick = count(index - 1, target - nums[index], nums, dp);
        return dp[index][target] = pick + notPick;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int total = 0;
        for (int i : nums) total += i;
        if ((total - target < 0) || ((total - target) % 2 == 1)) return 0;
        int s = (total - target) / 2;
        int[][] dp = new int[len][s + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return count(len - 1, s, nums, dp);
    }
}