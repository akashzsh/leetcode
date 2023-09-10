class Solution {
    public int countOrders(int n) {
        int mod = (int)(1e9 + 7);
        long prev = 1L, cur;
        for (int i = 1; i <= n; i++) {
            int space = (i - 1) * 2 + 1;
            int curVal = space * (space + 1) / 2;
            cur = prev * curVal % mod;
            prev = cur;
        }
        return (int)(prev);
    }
}