class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int low = 0, high = rows * columns - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / columns][mid % columns] == target) return true;
            else if (matrix[mid / columns][mid % columns] < target) low = mid + 1;
            else high = mid - 1;
        }
        
        return false;
    }
}