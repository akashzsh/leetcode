class Solution {
    public int combinationSum4(int[] nums, int k) {
        int[] dp = new int[k + 1];
        
        dp[0] = 1;
        
        for (int target = 1; target <= k; target++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) {
                    dp[target] += dp[target - nums[i]];
                }
            }
        }
        
        return dp[k];
    }
}

// Recursion

/*
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        
        return res;
    }
}
*/