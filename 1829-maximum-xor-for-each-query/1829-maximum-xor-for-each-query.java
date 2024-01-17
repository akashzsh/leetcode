class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];
        int maxPossible = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            maxPossible ^= nums[i];
            res[n - 1 - i] = maxPossible;
        }
        return res;
    }
}