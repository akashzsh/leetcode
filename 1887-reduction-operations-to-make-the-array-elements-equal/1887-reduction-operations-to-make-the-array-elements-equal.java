class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ops = 0, n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] == nums[i]) continue;
            ops = ops + n - i;
        }
        return ops;
    }
}