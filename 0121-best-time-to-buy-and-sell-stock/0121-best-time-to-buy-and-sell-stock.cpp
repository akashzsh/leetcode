class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0, buy = 0;
        
        for (int sell = 1, n = prices.size(); sell < n; sell++) {
            profit = max(profit, prices[sell] - prices[buy]);
            
            if (prices[sell] < prices[buy]) {
                buy = sell;
            }
        }
        
        return profit;
    }
};