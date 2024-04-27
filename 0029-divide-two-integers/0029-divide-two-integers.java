class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        
        boolean isNeg = false;
        
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNeg = true;
        }
        
        long n = Math.abs((long)dividend), d = Math.abs((long)divisor);
        long res = 0;
        
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            res += (1 << cnt);
            n = n - (d << (cnt));
        }
        
        if (res == (1 << 31)) {
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return isNeg ? (int)-res : (int)res;
    }
}