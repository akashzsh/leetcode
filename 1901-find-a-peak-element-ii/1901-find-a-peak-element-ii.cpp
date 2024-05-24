class Solution {
public:
    int find_max(int col, vector<vector<int>>& mat, int n) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > mat[idx][col]) {
                idx = i;
            }
        }
        return idx;
    }
    
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        
        int low = 0, high = m - 1;
        
        while (low <= high) {
            int j = low + ((high - low) >> 1);
            
            int i = find_max(j, mat, n);
            
            int left = j - 1 >= 0 ? mat[i][j - 1] : -1;
            int right = j + 1 < m ? mat[i][j + 1] : -1;
            
            if (mat[i][j] > left && mat[i][j] > right) {
                return {i, j};
            }
            
            if (mat[i][j] < left) {
                high = j - 1;
            } else {
                low = j + 1;
            }
        }
        
        return {-1, -1};
    }
};