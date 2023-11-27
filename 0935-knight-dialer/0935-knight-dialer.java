class Solution {
    public int knightDialer(int n) {
        int[][] jumps = {
            {4, 6}, {6, 8}, {7, 9},
            {4, 8}, {3, 9, 0}, {}, {1, 7, 0},
            {2, 6}, {1, 3}, {2, 4}
        };
        int m = 1_000_000_007;
        int[][] dp = new int[n][10];
        for (int cell = 0; cell <= 9; cell++) {
            dp[0][cell] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int cell = 0; cell <= 9; cell++) {
                int ans = 0;
                for (int next : jumps[cell]) {
                    ans = (ans + dp[i - 1][next]) % m;
                }
                dp[i][cell] = ans;
            }
        }
        int result = 0;
        for (int cell = 0; cell <= 9; cell++) {
            result = (result + dp[n - 1][cell]) % m;
        }
        return result;
    }
}