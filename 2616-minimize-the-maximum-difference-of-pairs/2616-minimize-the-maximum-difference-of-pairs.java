class Solution {
    private int count(int[] nums, int threshold, int len) {
        int index = 0, count = 0;
        while (index < len - 1) {
            if (nums[index + 1] - nums[index] <= threshold) {
                index++;
                count++;
            }
            index++;
        }
        return count;
    }
    
    public int minimizeMax(int[] nums, int p) {
        int len = nums.length;
        Arrays.sort(nums);
        int low = 0, high = nums[len - 1] - nums[0];
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (count(nums, mid, len) >= p) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}