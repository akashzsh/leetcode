class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n + 2];
        nums[0] = 1;
        for (int i = 0; i < n; i++) nums[i + 1] = arr[i];
        nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = (int)(-1e8);
                for (int idx = i; idx <= j; idx++) {
                    int curCost = nums[i - 1] * nums[idx] * nums[j + 1] +
                                  dp[i][idx - 1] + dp[idx + 1][j];
                    if (curCost > maxi) maxi = curCost;
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}