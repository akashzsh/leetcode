class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int left = money - (prices[0] + prices[1]);
        return left < 0 ? money : left;
    }
}