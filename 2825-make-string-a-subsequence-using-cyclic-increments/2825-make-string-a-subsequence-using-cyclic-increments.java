class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length(), i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j) ||
                ((s.charAt(i) - 'a' + 1) % 26 + 'a') == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}