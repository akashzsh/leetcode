class Solution {
    public boolean areNumbersAscending(String str) {
        int prev = (int)(-1e8), cur;
        String[] parts = str.split(" ");
        for (String s : parts) {
            if (Character.isDigit(s.charAt(0))) {
                cur = 0;
                for (int i = 0; i < s.length(); i++) {
                    cur = cur * 10 + (s.charAt(i) - '0');
                }
                if (cur <= prev) return false;
                prev = cur;
            }
        }
        return true;
    }
}