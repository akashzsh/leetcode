class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    if (!seen.add(board[r][c] + "row" + r) ||
                        !seen.add(board[r][c] + "col" + c) ||
                        !seen.add(board[r][c] + "block" + r/3 + " " + c/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}