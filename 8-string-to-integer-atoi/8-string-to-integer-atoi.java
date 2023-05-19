class Solution {
    public int myAtoi(String s) {
        int result = 0, sign = 1, i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i < s.length())
            if (s.charAt(i) == '-') {
                i++;
                sign = -1;
            } else if (s.charAt(i) == '+') i++;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}