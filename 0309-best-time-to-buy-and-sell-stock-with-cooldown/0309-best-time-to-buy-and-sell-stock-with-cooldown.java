class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev1 = new int[2];
        int[] prev2 = new int[2];
        int[] curr = new int[2];
        for (int day = n - 1; day >= 0; day--) {
            curr[1] = Math.max(-prices[day] + prev1[0], prev1[1]);
            curr[0] = Math.max(prices[day] + prev2[1], prev1[0]);
            prev2 = (int[])(prev1.clone());
            prev1 = (int[])(curr.clone());
        }
        return curr[1];
    }
}