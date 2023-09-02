class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) set.add(word);
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder cur = new StringBuilder();
            int mini = n;
            for (int idx = i; idx < n; idx++) {
                cur.append(s.charAt(idx));
                int curSize = set.contains(cur.toString()) ? 0 : cur.length();
                int nextSize = dp[idx + 1];
                mini = Math.min(mini, curSize + nextSize);
            }
            dp[i] = mini;
        }
        return dp[0];
    }
}