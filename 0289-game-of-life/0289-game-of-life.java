class Solution {
    private static final int[][] dim = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private static final int dead = 0;
    private static final int alive = 1;
    private static final int deadToAlive = 2;
    private static final int aliveToDead = 3;
    
    private boolean isAlive(int x, int y, int rows, int cols, int[][] board) {
        return x >= 0 && y >= 0 && x < rows && y < cols && (board[x][y] == alive || board[x][y] == aliveToDead);
    }
    
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int alive = 0;
                for (int[] d : dim) {
                    alive += isAlive(i + d[0], j + d[1], n, m, board) ? 1 : 0;
                }
                if (board[i][j] == 0) {
                    if (alive == 3) {
                        board[i][j] = deadToAlive;
                    }
                } else {
                    if (alive != 2 && alive != 3) {
                        board[i][j] = aliveToDead;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == deadToAlive) board[i][j] = 1;
                else if (board[i][j] == aliveToDead) board[i][j] = 0;
            }
        }
    }
}