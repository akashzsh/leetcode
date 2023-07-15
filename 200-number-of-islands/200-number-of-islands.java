class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public void bfs(int row, int col, boolean[][] v, char[][] grid) {
        v[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        int n = grid.length, m = grid[0].length;
        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            for (int i = -1; i <= 1; i++) {
                int nrow = x + i;
                if (nrow >= 0 && nrow < n && !v[nrow][y] && grid[nrow][y] == '1') {
                    v[nrow][y] = true;
                    q.offer(new Pair(nrow, y));
                }
            }
            for (int i = -1; i <= 1; i++) {
                int ncol = y + i;
                if (ncol >= 0 && ncol < m && !v[x][ncol] && grid[x][ncol] == '1') {
                    v[x][ncol] = true;
                    q.offer(new Pair(x, ncol));
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, cnt = 0;
        boolean[][] v = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!v[i][j] && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, v, grid);
                }
            }
        }
        return cnt;
    }
}