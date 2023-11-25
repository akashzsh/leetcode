class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0, prefixSum = 0, n = nums.length;
        int[] result = new int[n];
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < n; i++) {
            int left = prefixSum;
            int right = sum - prefixSum - nums[i];
            result[i] = (nums[i] * i) - left + right - (nums[i] * (n - i - 1));
            prefixSum += nums[i];
        }
        return result;
    }
}