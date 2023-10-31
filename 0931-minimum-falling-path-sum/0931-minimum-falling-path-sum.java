class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int left, right, down;
                left = right = down = Integer.MAX_VALUE;
                if (col - 1 >= 0) left = dp[row - 1][col - 1];
                if (col + 1 < n) right = dp[row - 1][col + 1];
                dp[row][col] = matrix[row][col] + Math.min(dp[row - 1][col], Math.min(left, right));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}