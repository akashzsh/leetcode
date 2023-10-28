class Solution {
    long mod = 1000000007;
    int a = 0, e = 1, i = 2, o = 3, u = 4;
    long[][] dp;
    
    private long solve(int ch, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (dp[ch][n] != -1) return dp[ch][n];
        
        if (ch == a) {
            return dp[ch][n] = solve(e, n - 1) % mod;
        } else if (ch == e) {
            return dp[ch][n] = (solve(a, n - 1) + solve(i, n - 1)) % mod;
        } else if (ch == i) {
            return dp[ch][n] = (solve(a, n - 1) + solve(e, n - 1) + solve(o, n - 1) + solve(u, n - 1)) % mod;
        } else if (ch == o) {
            return dp[ch][n] = (solve(i, n - 1) + solve(u, n - 1)) % mod;
        } else if (ch == u) {
            return dp[ch][n] = solve(a, n - 1) % mod;
        }
        
        return dp[ch][n] = 0;
    }
    
    public int countVowelPermutation(int n) {
        long result = 0;
        dp = new long[5][n + 1];
        for (long[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        result = (result + solve(a, n -1)) % mod;
        result = (result + solve(e, n -1)) % mod;
        result = (result + solve(i, n -1)) % mod;
        result = (result + solve(o, n -1)) % mod;
        result = (result + solve(u, n -1)) % mod;
        
        return (int)(result);
    }
}