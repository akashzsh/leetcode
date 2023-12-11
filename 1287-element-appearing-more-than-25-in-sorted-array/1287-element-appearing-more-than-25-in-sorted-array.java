class Solution {
    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    
    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int target = n / 4;
        int[] candidates = {arr[n / 4], arr[n / 2], arr[3 * n / 4]};
        for (int ch : candidates) {
            int lower = lowerBound(arr, ch);
            int upper = upperBound(arr, ch);
            if (upper - lower > target) {
                return ch;
            }
        }
        return 0;
    }
}