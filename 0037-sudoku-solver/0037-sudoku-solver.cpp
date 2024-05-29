class Solution {
public:
    bool is_safe(vector<vector<char>>& board, char& ch, int& x, int& y) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == ch || board[x][i] == ch || board[3 * (x / 3) + (i / 3)][3 * (y / 3) + (i % 3)] == ch) {
                return false;
            }
        }
        return true;
    }
    
    bool place(vector<vector<char>>& board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (is_safe(board, ch, i, j)) {
                            board[i][j] = ch;
                            if (place(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    void solveSudoku(vector<vector<char>>& board) {
        place(board);
    }
};