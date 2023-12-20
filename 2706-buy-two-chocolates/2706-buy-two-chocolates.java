class Solution {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        int min = Math.min(prices[0], prices[1]);
        int secondMin = Math.max(prices[0], prices[1]);
        for (int i = 2; i < n; i++) {
            if (prices[i] < min) {
                secondMin = min;
                min = prices[i];
            } else if (prices[i] < secondMin) {
                secondMin = prices[i];
            }
        }
        if (min + secondMin > money) {
            return money;
        }
        return money - min - secondMin;
    }
}