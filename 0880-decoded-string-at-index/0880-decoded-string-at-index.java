class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long cur = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                cur *= ch - '0';
            } else {
                cur++;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                cur /= ch - '0';
                k %= cur;
            } else {
                if (k == 0 || k == cur) return ch + "";
                cur--;
            }
        }
        return "";
    }
}