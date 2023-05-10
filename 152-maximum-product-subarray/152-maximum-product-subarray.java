class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE, prod = 1;
        for (int i : nums) {
            prod *= i;
            maxProduct = Math.max(maxProduct, prod);
            if (i == 0) prod = 1;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            prod *= nums[i];
            maxProduct = Math.max(maxProduct, prod);
            if (nums[i] == 0) prod = 1;
        }
        return maxProduct;
    }
}