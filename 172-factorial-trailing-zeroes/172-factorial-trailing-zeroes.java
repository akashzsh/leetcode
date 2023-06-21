class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            int tmp = n / 5;
            res += tmp;
            n = tmp;
        }
        return res;
    }
}