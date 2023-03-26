class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int currentSum = 0;
        for (int i = 0; i < length; i++) {
            currentSum += nums[i];
            nums[i] = currentSum; 
        }
        return nums;
    }
}