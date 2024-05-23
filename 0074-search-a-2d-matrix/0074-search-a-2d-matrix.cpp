class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix[0].size();
        int low = 0, high = matrix.size() * m - 1;
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            
            if (matrix[mid / m][mid % m] == target) {
                return true;
            }
            
            if (matrix[mid / m][mid % m] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
};