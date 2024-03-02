class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int left = 0, right = nums.length - 1;
        
        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[k] = nums[left] * nums[left];
                left++;
            } else {
                res[k] = nums[right] * nums[right];
                right--;
            }
        }
        
        return res;
    }
}