class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = prices[0], profit = 0;
        
        for (int day = 1; day < prices.length; day++) {
            
            int curProfit = prices[day] - buyDay;
            
            profit = Math.max(profit, curProfit);
            
            buyDay = Math.min(buyDay, prices[day]);
        }
        
        return profit;
    }
}