class Solution {
    public void fill(int[][] grid, int i, int j, int color, boolean[][] vis, int[] dr, int[] dc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        
        while (!q.isEmpty()) {
            int size = q.size();
            int[] cur = q.poll();
            
            vis[cur[0]][cur[1]] = true;
            
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k], nc = cur[1] + dc[k];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && vis[nr][nc] == false && grid[nr][nc] == grid[cur[0]][cur[1]]) {
                    q.add(new int[]{nr, nc});
                }
            }
            
            grid[cur[0]][cur[1]] = color;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length, c = image[0].length;
        boolean[][] vis = new boolean[r][c];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        fill(image, sr, sc, color, vis, dr, dc);
        return image;
    }
}