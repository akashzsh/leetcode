class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1, right = 0;
        while (right < nums.length) {
            if (nums[right] > nums[left - 1]) nums[left++] = nums[right];
            right++;
        }
        return left;
    }
}