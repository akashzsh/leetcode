class Solution {
    int M = 1_000_000_007;
    
    public int f(int m, int n, int moves, int i, int j, int[][][] dp) {
        if (i == m || j == n || i < 0 || j < 0) {
            return 1;
        }
        
        if (moves == 0) {
            return 0;
        }
        
        if (dp[i][j][moves] >= 0) {
            return dp[i][j][moves];
        }
        
        return dp[i][j][moves] = (
            ((
                f(m, n, moves - 1, i - 1, j, dp) + f(m, n, moves - 1, i + 1, j, dp)
            ) % M) + (
                (
                    f(m, n, moves - 1, i, j - 1, dp) + f(m, n, moves - 1, i, j + 1, dp)
                ) % M
            )
        ) % M;
    }
    
    public int findPaths(int m, int n, int moves, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][moves + 1];
        for (int[][] v : dp) {
            for(int[] vec : v) {
                Arrays.fill(vec, -1);
            }
        }
        return f(m, n, moves, startRow, startColumn, dp);
    }
}