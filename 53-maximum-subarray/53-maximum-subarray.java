class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], current = 0;
        for (int i : nums) {
            current += i;
            if (current > max) max = current;
            if (current < 0) current = 0;
        }
        return max;
    }
}