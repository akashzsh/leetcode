class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, best = 0;
        for (int sell = 1; sell < prices.length; sell++) {
            int current = prices[sell] - prices[buy];
            if (current > 0 && current > best) best = current;
            if (current < 0) buy = sell;
        }
        return best;
    }
}