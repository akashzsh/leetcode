class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] > nums[i]) {
                ans = prefix[i];
            }
        }
        return ans == 0 ? -1 : ans;
    }
}