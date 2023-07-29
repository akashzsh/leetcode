class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1, len = nums.length;
        for (int i = 0; i < len; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr] < 0) {
                duplicate = curr;
                break;
            }
            nums[curr] *= -1;
        }
        for (int i = 0; i < len; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return duplicate;
    }
}