class Solution {
    private boolean increase(int nums[], int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }
    
    private boolean decrease(int nums[], int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) return false;
        }
        return true;
    }
    
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        return increase(nums, n) || decrease(nums, n);
    }
}