class Solution {
    public int triangularSum(int[] nums) {
        int i = 0, j = 1, high = nums.length;
        while (j < high) {
            nums[i] = (nums[i] + nums[j]) % 10;
            i++;
            j++;
            if (j == high) {
                high--;
                i = 0;
                j = 1;
            }
        }
        return nums[0];
    }
}