class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while (absDividend >= absDivisor) {
            long temp = absDivisor, count = 1;
            while (absDividend >= temp) {
                temp = temp << 1;
                count = count << 1;
            }
            result += count >> 1;
            absDividend -= temp >> 1;
        }
        return isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}