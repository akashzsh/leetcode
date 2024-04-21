// Memoization

class Solution {
    public int f(int j, int digit, int[][] grid, int[][] dp) {
        if (j == grid[0].length) {
            return 0;
        }
        
        if (dp[j][digit] != -1) {
            return dp[j][digit];
        }
        
        int cost = 0;
        
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][j] != digit) {
                cost++;
            }
        }
        
        int res = 1_000_000_000;
        
        for (int option = 0; option <= 9; option++) {
            if (option != digit) {
                res = Math.min(res, cost + f(j + 1, option, grid, dp));
            }
        }
        
        return dp[j][digit] = res;
    }
    
    public int minimumOperations(int[][] grid) {
        int res = 1_000_000_000;
        
        int[][] dp = new int[grid[0].length][10];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        for (int digit = 0; digit <= 9; digit++) {
            res = Math.min(res, f(0, digit, grid, dp));
        }
        
        return res;
    }
}

// Recursion

/*
class Solution {
    public int f(int j, int digit, int[][] grid) {
        if (j == grid[0].length) {
            return 0;
        }
        
        int cost = 0;
        
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][j] != digit) {
                cost++;
            }
        }
        
        int res = 1_000_000_000;
        
        for (int option = 0; option <= 9; option++) {
            if (option != digit) {
                res = Math.min(res, cost + f(j + 1, option, grid));
            }
        }
        
        return res;
    }
    
    public int minimumOperations(int[][] grid) {
        int res = 1_000_000_000;
        
        for (int digit = 0; digit <= 9; digit++) {
            res = Math.min(res, f(0, digit, grid));
        }
        
        return res;
    }
}
*/