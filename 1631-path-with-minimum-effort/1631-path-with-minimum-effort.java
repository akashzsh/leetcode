class Tuple {
    int dist;
    int row;
    int col;
    Tuple (int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> q = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int m = heights.length, n = heights[0].length;
        int[][] v = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v[i][j] = (int)(1e9);
            }
        }
        v[0][0] = 0;
        q.offer(new Tuple(0, 0, 0));
        int dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int d = t.dist, r = t.row, c = t.col;
            if (r == m - 1 && c == n - 1) return d;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int effort = Math.max(d, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (effort < v[nr][nc]) {
                        v[nr][nc] = effort;
                        q.offer(new Tuple(v[nr][nc], nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}