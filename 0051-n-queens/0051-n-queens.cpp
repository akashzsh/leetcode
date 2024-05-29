class Solution {
public:
    void f(int col, vector<string>& board, vector<vector<string>>& res, vector<int>& ud, vector<int>& ld, vector<int>& left, int& N) {
        if (col == N) {
            res.push_back(board);
            return;
        }
        
        for (int row = 0; row < N; row++) {
            if (ud[N - 1 + col - row] == 0 && ld[row + col] == 0 && left[row] == 0) {
                board[row][col] = 'Q';
                ud[N - 1 + col - row] = 1;
                ld[row + col] = 1;
                left[row] = 1;
                f(col + 1, board, res, ud, ld, left, N);
                board[row][col] = '.';
                ud[N - 1 + col - row] = 0;
                ld[row + col] = 0;
                left[row] = 0;
            }
        }
    }
    
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        
        string s(n, '.');
        
        vector<string> board(n, s);
        
        vector<int> ud(2 * n + 1), ld(2 * n + 1), left(n);
        
        f(0, board, res, ud, ld, left, n);
        
        return res;
    }
};