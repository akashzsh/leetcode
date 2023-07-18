class Pair {
    int x;
    int y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] v = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        q.offer(new Pair(i, j));
                        v[i][j] = 1;
                    }
                }
            }
        }
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int x = q.peek().x, y = q.peek().y;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && v[nx][ny] == 0 && grid[nx][ny] == 1) {
                    q.offer(new Pair(nx, ny));
                    v[nx][ny] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j] == 0 && grid[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
}