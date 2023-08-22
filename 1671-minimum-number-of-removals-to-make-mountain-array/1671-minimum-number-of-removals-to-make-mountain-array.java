class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length, maxi = 1;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
            if (dp1[i] > 1 && dp2[i] > 1) {
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
            }
        }
        return n - maxi;
    }
}