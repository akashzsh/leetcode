class Solution {
    public void dfs(int i, int j, boolean[][] vis, char[][] grid, int[] dr, int[] dc) {
        vis[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            
            int ni = i + dr[k], nj = j + dc[k];
            
            if (ni >= 0 && ni < vis.length && nj >= 0 && nj < vis[0].length && grid[ni][nj] != '0' && !vis[ni][nj]) {
                dfs(ni, nj, vis, grid, dr, dc);
            }
            
        }
    }
    
    public int numIslands(char[][] grid) {
        int R = grid.length, C = grid[0].length;
        boolean[][] vis = new boolean[R][C];
        
        int islands = 0;
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!vis[i][j] && grid[i][j] != '0') {
                    islands++;
                    dfs(i, j, vis, grid, dr, dc);
                }
            }
        }
        
        return islands;
    }
}