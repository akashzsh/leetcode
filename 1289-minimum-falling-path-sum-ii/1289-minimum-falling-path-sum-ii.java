// Space Optimization

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int res = 1_000_000_000;
        
        int prev[] = new int[grid[0].length], cur[] = new int[grid[0].length];
        
        for (int j = 0; j < grid[0].length; j++) {
            prev[j] = grid[grid.length - 1][j];
        }
        
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                int sum = 1_000_000_000;
                for (int k = 0; k < grid[0].length; k++) {
                    int ni = i + 1, nj = k;
                    if (nj != j) {
                        sum = Math.min(sum, grid[i][j] + prev[nj]);
                    }
                }
                cur[j] = sum;
            }
            System.arraycopy(cur, 0, prev, 0, grid[0].length);
        }
        
        for (int j = 0; j < grid[0].length; j++) {
            res = Math.min(res, prev[j]);
        }
        
        return res;
    }
}

// Tabulation

/*
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int res = 1_000_000_000;
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int j = 0; j < grid[0].length; j++) {
            dp[grid.length - 1][j] = grid[grid.length - 1][j];
        }
        
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                int sum = 1_000_000_000;
                for (int k = 0; k < grid[0].length; k++) {
                    int ni = i + 1, nj = k;
                    if (nj != j) {
                        sum = Math.min(sum, grid[i][j] + dp[ni][nj]);
                    }
                }
                dp[i][j] = sum;
            }
        }
        
        for (int j = 0; j < grid[0].length; j++) {
            res = Math.min(res, dp[0][j]);
        }
        
        return res;
    }
}
*/

// Recursion + Memoization

/*
class Solution {
    public int f(int i, int j, int[][] grid, int[][] dp) {
        if (i == grid.length - 1) {
            return grid[i][j];
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
       
        int sum = 1_000_000_000;
        
        for (int k = 0; k < grid[0].length; k++) {
            int ni = i + 1, nj = k;
            if (nj != j) {
                sum = Math.min(sum, grid[i][j] + f(ni, nj, grid, dp));
            }
        }
        
        return dp[i][j] = sum;
    }
    
    public int minFallingPathSum(int[][] grid) {
        int res = 1_000_000_000;
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        for (int j = 0; j < grid[0].length; j++) {
            res = Math.min(res, f(0, j, grid, dp));
        }
        
        return res;
    }
}
*/