class Solution {
    public int minCut(String str) {
        char[] s = str.toCharArray();
        int n = s.length, min = 0;
        int[] cut = new int[n];
        boolean[][] palindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = 0; j <= i; j++) {
                if (s[i] == s[j] && (i - j < 3 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}