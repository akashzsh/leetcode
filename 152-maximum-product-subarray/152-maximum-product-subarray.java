class Solution {
    public int maxProduct(int[] nums) {
        int maxLeft = nums[0], maxRight = nums[0], prod = 1, zero = 0;
        for (int i : nums) {
            prod *= i;
            if (i == 0) {
                prod = 1;
                zero = 1;
                continue;
            }
            maxLeft = Math.max(maxLeft, prod);
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            if (nums[i] == 0) {
                prod = 1;
                zero = 1;
                continue;
            }
            maxRight = Math.max(maxRight, prod);
        }
        if (zero == 1) return Math.max(Math.max(maxLeft, maxRight), 0);
        return Math.max(maxLeft, maxRight);
    }
}