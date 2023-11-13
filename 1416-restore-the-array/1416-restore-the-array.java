class Solution {
    int[] dp;
    
    private int solve(int start, String s, int k, int n) {
        if (start >= n) {
            return 1;
        }
        if (dp[start] != -1) return dp[start];
        if (s.charAt(start) == '0') {
            return dp[start] = 0;
        }
        int ans = 0;
        long num = 0;
        for (int end = start; end < n; end++) {
            num = (num * 10) + (s.charAt(end) - '0');
            if (num > k) break;
            ans += solve(end + 1, s, k, n);
            ans = ans % 1_000_000_007;
        }
        return dp[start] = ans;
    }
    
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, k, n);
    }
}