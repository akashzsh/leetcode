class Solution {
    public int solve(int[] nums, int start, int end) {
        int prev = nums[start - 1], prev1 = 0;
        for (int i = start; i < end; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev1;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
    
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int notLast = solve(nums, 1, len - 1);
        int notFirst = solve(nums, 2, len);
        return Math.max(notLast, notFirst);
    }
}