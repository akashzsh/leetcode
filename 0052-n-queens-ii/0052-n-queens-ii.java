class Solution {
    public int f(int col, char[][] board, int n, int[] leftSide, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == n) {
            return 1;
        }
        int cnt = 0;
        for (int row = 0; row < n; row++) {
            if (leftSide[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftSide[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                cnt += f(col + 1, board, n, leftSide, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftSide[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
        return cnt;
    }
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] leftSide = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        return f(0, board, n, leftSide, lowerDiagonal, upperDiagonal);
    }
}