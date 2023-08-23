class Solution {
    public int minCost(int n, int[] nums) {
        int c = nums.length;
        int[] cuts = new int[c + 2];
        cuts[0] = 0;
        for (int i = 0; i < c; i++) cuts[i + 1] = nums[i];
        cuts[c + 1] = n;
        Arrays.sort(cuts);
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;
                int mini = (int)(1e9);
                for (int idx = i; idx <= j; idx++) {
                    int cur = cuts[j + 1] - cuts[i - 1] + dp[i][idx - 1] + dp[idx + 1][j];
                    if (cur < mini) mini = cur;
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}