class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];
        int[] curr = new int[2];
        for (int day = n - 1; day >= 0; day--) {
            curr[1] = Math.max(-prices[day] + prev[0], prev[1]);
            curr[0] = Math.max(prices[day] - fee + prev[1], prev[0]);
            prev = curr.clone();
        }
        return prev[1];
    }
}