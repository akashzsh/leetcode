class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] prev = new int[m][m];
        int[][] curr = new int[m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) prev[j1][j2] = grid[n - 1][j1];
                else prev[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = (int)(-1e8);
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int val = 0;
                            if (j1 == j2) val = grid[i][j1];
                            else val = grid[i][j1] + grid[i][j2];
                            if (j1 + dj1 >= 0 && j2 + dj2 >= 0 && j1 + dj1 < m && j2 + dj2 < m)
                            val += prev[j1 + dj1][j2 + dj2];
                            else val += (int)(-1e8);
                            maxi = Math.max(maxi, val);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            for (int a = 0; a < m; a++) {
                prev[a] = (int[])(curr[a].clone());
            }
        }
        return prev[0][m -1];
    }
}