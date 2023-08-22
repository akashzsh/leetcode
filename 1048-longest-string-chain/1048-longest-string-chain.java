class Solution {
    public boolean check(String s, String t) {
        int n = s.length(), m = t.length();
        if (n != m + 1) return false;
        int i = 0, j = 0;
        while (i < n) {
            if (j < m && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return i == n && j == m;
    }
    
    public int longestStrChain(String[] words) {
        int n = words.length, maxi = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (check(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}