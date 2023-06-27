class Solution {
    public List<String> construct(char[][] board) {
        List<String> newBoard = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String tmp = new String(board[i]);
            newBoard.add(tmp);
        }
        return newBoard;
    }
    
    public void solve(int n, List<List<String>> res, char[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int col) {
        if (col == n) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                solve(n, res, board, leftRow, upperDiagonal, lowerDiagonal, col + 1);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
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
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[n * 2 - 1];
        int[] lowerDiagonal = new int[n * 2 - 1];
        solve(n, res, board, leftRow, upperDiagonal, lowerDiagonal, 0);
        return res;
    }
}