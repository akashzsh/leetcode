class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int res = 0, i = 0;
        boolean isPositive = true;
        
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i < n) {
            if (s.charAt(i) == '-') {
                isPositive = false;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }
        
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
            i++;
        }
        
        return res * (isPositive ? 1 : -1);
    }
}