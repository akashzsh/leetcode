class Solution {
    public int maxProfit(int[] prices) {
        int curMin = prices[0], profit = 0;
        
        for (int day = 1; day < prices.length; day++) {
            
            int curProfit = prices[day] - curMin;
            
            profit = Math.max(profit, curProfit);
            
            curMin = Math.min(curMin, prices[day]);
        }
        
        return profit;
    }
}