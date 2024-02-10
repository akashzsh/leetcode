class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), cnt = 0;
        boolean[][] dp = new boolean[n][n];
        // Take "len" length substring
        for (int len = 1; len <= n; len++) {
            // Start index
            for (int i = 0; i + len - 1 < n; i++) {
                // End index
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                cnt += dp[i][j] ? 1 : 0;
            }
        }
        return cnt;
    }
}