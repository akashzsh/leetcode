class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        prev[0] = prev[1] = 0;
        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) {
                    int get = -prices[day] + prev[0];
                    int notGet = 0 + prev[1];
                    profit = Math.max(get, notGet);
                } else {
                    int drop = prices[day] + prev[1];
                    int notDrop = 0 + prev[0];
                    profit = Math.max(drop, notDrop);
                }
                curr[buy] = profit;
            }
            prev = curr;
        }
        return prev[1];
    }
}