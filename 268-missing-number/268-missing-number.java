class Solution {
    public int missingNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) result ^= nums[i];
        for (int i = 0; i <= nums.length; i++) result ^= i;
        return result;
    }
}