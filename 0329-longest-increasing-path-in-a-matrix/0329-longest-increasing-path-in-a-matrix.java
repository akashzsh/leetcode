class Solution {
    public int dfs(int i, int j, int[][] matrix, int[] dr, int[] dc, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int ans = 1;
        
        for (int k = 0; k < 4; k++) {
            int ni = i + dr[k], nj = j + dc[k];
            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[i][j] < matrix[ni][nj]) {
                ans = Math.max(ans, 1 + dfs(ni, nj, matrix, dr, dc, dp));
            }
        }
        
        return dp[i][j] = ans;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int res = 1;
        
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, matrix, dr, dc, dp));
            }
        }
        
        return res;
    }
}