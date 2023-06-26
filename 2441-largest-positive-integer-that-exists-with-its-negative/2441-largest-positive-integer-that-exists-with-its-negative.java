class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == 0) return nums[high];
            else if (nums[low] + nums[high] > 0) high--;
            else low++;
        }
        return -1;
    }
}