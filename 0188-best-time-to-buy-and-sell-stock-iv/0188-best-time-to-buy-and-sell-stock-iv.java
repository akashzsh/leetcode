class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            int[][] curr = new int[2][k + 1];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        int get = -prices[day] + prev[0][cap];
                        int notGet = 0 + prev[1][cap];
                        curr[buy][cap] = Math.max(get, notGet);
                    } else {
                        int drop = prices[day] + prev[1][cap - 1];
                        int notDrop = 0 + prev[0][cap];
                        curr[buy][cap] = Math.max(drop, notDrop);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][k];
    }
}