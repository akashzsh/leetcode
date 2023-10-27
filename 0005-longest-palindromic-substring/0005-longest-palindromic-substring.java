class Solution {
    int[][] dp;
    
    private int isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return 1;
        }
        
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrome(s, i + 1, j - 1);
        }
        
        return 0;
    }
    
    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 0, startPos = 0;
        dp = new int[n + 1][n + 1];
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) == 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startPos = i;
                    }
                }
            }
        }
        
        return s.substring(startPos, startPos + maxLen);
    }
}