class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length, breakPoint = -1, cur = 0;
        Arrays.sort(nums);
        for (int i = 2; i < n; i++) {
            if (i % 3 == 0) {
                continue;
            }
            if ((i + 1) % 3 == 0) {
                if ((nums[i] - nums[i - 1] > k) || (nums[i] - nums[i - 2] > k)) return new int[][] {};
            }
        }
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                breakPoint++;
                cur = 0;
            }
            ans[breakPoint][cur++] = nums[i];
        }
        return ans;
    }
}