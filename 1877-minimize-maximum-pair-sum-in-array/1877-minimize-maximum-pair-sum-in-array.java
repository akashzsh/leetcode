class Solution {
    public int minPairSum(int[] nums) {
        int len = nums.length / 2;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = Math.max(sum, nums[i] + nums[nums.length - 1 - i]);
        }
        return sum;
    }
}