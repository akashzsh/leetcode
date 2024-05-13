class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(), res = 0;
        
        // process to make first col compulsory 1
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                continue;
            } else {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                }
            }
        }
        
        // contribution of first col compulsory 1
        res = n * (1 << (m - 1));
        
        // now check for every col whether default configuration gives more 1 or need to flip. If we flip then n - one_cnt will be the ones stored in matrix
        for (int j = 1; j < m; j++) {
            int one_cnt = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) {
                    one_cnt++;
                }
            }
            if (one_cnt > (n - one_cnt)) {
                res = res + (one_cnt * (1 << (m - 1 - j)));
            } else {
                res = res + ((n - one_cnt) * (1 << (m - 1 - j)));
            }
        }
        
        return res;
    }
};