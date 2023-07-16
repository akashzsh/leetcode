class Pair {
    int row;
    int col;
    int time;
    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] v = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    v[i][j] = 2;
                    q.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 0) v[i][j] = 0;
                else cntFresh++;
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int maxTime = 0, cnt = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            maxTime = Math.max(maxTime, t);
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = r + dx[i];
                int ncol = c + dy[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && v[nrow][ncol] != 2) {
                    cnt++;
                    q.offer(new Pair(nrow, ncol, t + 1));
                    v[nrow][ncol] = 2;
                }
            }
        }
        if (cnt != cntFresh) return -1;
        return maxTime;
    }
}