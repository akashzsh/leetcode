class Solution {
    public void place(int col, char[][] board, List<List<String>> res, int n, int[] leftSide, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == n) {
            List<String> vec = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vec.add(new String(board[i]));
            }
            res.add(new ArrayList<>(vec));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftSide[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftSide[row] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;
                place(col + 1, board, res, n, leftSide, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                leftSide[row] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] leftSide = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        place(0, board, res, n, leftSide, upperDiagonal, lowerDiagonal);
        return res;
    }
}