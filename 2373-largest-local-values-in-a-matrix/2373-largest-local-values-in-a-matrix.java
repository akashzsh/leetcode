class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int p = i; p < i + 3; p++) {
                    for (int q = j; q < j + 3; q++) {
                        res[i][j] = Math.max(res[i][j], grid[p][q]);
                    }
                }
            }
        }
        return res;
    }
}