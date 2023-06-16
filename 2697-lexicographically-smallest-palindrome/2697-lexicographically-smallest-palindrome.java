class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(Character.toString(Math.min(s.charAt(i), s.charAt(n - i - 1))));
        }
        return result.toString();
    }
}