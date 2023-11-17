class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, nums[i] + nums[nums.length - 1 - i]);
        }
        return sum;
    }
}