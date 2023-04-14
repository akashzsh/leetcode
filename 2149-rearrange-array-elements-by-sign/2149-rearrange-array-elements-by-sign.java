class Solution {
    public int[] rearrangeArray(int[] nums) {
        int left = 0, right = nums.length / 2;
        int[] auxiliary = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) auxiliary[left++] = nums[i];
            else auxiliary[right++] = nums[i];
        }
        left = 0;
        right = nums.length / 2;
        for (int i = 0; i < auxiliary.length; i++) {
            if (i % 2 == 0) nums[i] = auxiliary[left++];
            else nums[i] = auxiliary[right++];
        }
        return nums;
    }
}