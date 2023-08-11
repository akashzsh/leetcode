class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            prev[i] = i % coins[0] == 0 ? 1 : 0;
        }
        for (int index = 1; index < len; index++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + prev[target];
                int take = 0;
                if (coins[index] <= target)
                    take = curr[target - coins[index]];
                curr[target] = take + notTake;
            }
            prev = curr;
        }
        return prev[amount];
    }
}