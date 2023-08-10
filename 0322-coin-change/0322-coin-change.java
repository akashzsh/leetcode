class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int)(1e9);
        }
        for (int index = 1; index < len; index++) {
            for (int target = 0; target <= amount; target++) {
                int notPick = 0 + dp[index - 1][target];
                int pick = (int)(1e9);
                if (coins[index] <= target)
                    pick = 1 + dp[index][target - coins[index]];
                dp[index][target] = Math.min(pick, notPick);
            }
        }
        int ans = dp[len - 1][amount];
        return ans >= (int)(1e9) ? -1 : ans;
    }
}