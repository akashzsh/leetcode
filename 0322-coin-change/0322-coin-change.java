class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) prev[i] = i / coins[0];
            else prev[i] = (int)(1e9);
        }
        for (int index = 1; index < len; index++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notPick = 0 + prev[target];
                int pick = (int)(1e9);
                if (coins[index] <= target)
                    pick = 1 + curr[target - coins[index]];
                curr[target] = Math.min(pick, notPick);
            }
            prev = curr;
        }
        int ans = prev[amount];
        return ans >= (int)(1e9) ? -1 : ans;
    }
}