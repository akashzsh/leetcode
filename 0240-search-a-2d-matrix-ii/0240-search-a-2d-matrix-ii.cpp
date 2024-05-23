class Solution {
public:
    bool searchMatrix(vector<vector<int>>& grid, int target) {
        int n = grid.size(), m = grid[0].size();
        
        int x = 0, y = m - 1;
        
        while (x < n && y >= 0) {
            if (grid[x][y] == target) {
                return true;
            }
            
            if (target < grid[x][y]) {
                y--;
            } else if (target > grid[x][y]) {
                x++;
            }
        }
        
        return false;
    }
};