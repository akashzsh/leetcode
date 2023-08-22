class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int cur : nums) {
            if (i < 2 || cur > nums[i - 2]) nums[i++] = cur;
        }
        return i;
    }
}