class Solution {
    public void dfs(int r, int c, int[][] v, char[][] board, int m, int n) {
        v[r][c] = 1;
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i], nc = c + dy[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && v[nr][nc] == 0 && board[nr][nc] == 'O') dfs(nr, nc, v, board, m, n);
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] v = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (v[0][i] == 0 && board[0][i] == 'O')
                dfs(0, i, v, board, m, n);
            if (v[m - 1][i] == 0 && board[m - 1][i] == 'O')
                dfs(m - 1, i, v, board, m, n);
        }
        for (int i = 0; i < m; i++) {
            if (v[i][0] == 0 && board[i][0] == 'O')
                dfs(i, 0, v, board, m, n);
            if (v[i][n - 1] == 0 && board[i][n - 1] == 'O')
                dfs(i, n - 1, v, board, m, n);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (v[i][j] == 0 && board[i][j] == 'O') board[i][j] = 'X';
    }
}