class Solution {
    private int f(int[] nums, int threshold) {
        int curSum = 0, k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] <= threshold) {
                curSum += nums[i];
            } else {
                k++;
                curSum = nums[i];
            }
        }
        return k;
    }
    
    public int splitArray(int[] nums, int k) {
        int low = -1, high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (f(nums, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}