class Solution {
    private int f(int i, String s, int n, HashSet<String> set, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        StringBuilder cur = new StringBuilder();
        int mini = n;
        for (int idx = i; idx < n; idx++) {
            cur.append(s.charAt(idx));
            int curSize = set.contains(cur.toString()) ? 0 : cur.length();
            int nextSize = f(idx + 1, s, n, set, dp);
            mini = Math.min(mini, curSize + nextSize);
        }
        return dp[i] = mini;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) set.add(word);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, s, n, set, dp);
    }
}