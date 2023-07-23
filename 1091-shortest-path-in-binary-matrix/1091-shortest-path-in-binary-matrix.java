class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, src = grid[0][0], des = grid[n - 1][n - 1];
        if (n == 1 && grid[0][0] == 0) return 1;
        if (src == 1) return -1;
        int[][] vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = (int)(1e9);
            }
        }
        vis[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1}, dc[] = {0, 1, 1, 1, 0, -1, -1, -1, 0};
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int dist = tmp[0], x = tmp[1], y = tmp[2];
            for (int i = 0; i < 8; i++) {
                int nr = x + dr[i], nc = y + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && vis[x][y] + 1 < vis[nr][nc]) {
                    vis[nr][nc] = vis[x][y] + 1;
                    if (nr == n - 1 && nc == n - 1) return vis[nr][nc] + 1;
                    q.offer(new int[] {vis[nr][nc], nr, nc});
                }
            }
        }
        return -1;
    }
}