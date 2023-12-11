class Solution {
    private int findLargest(int[][] mat, int col) {
        int maxIndex = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[maxIndex][col]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int largestIdx = findLargest(mat, mid);
            int left = mid - 1 >= 0 ? mat[largestIdx][mid - 1] : -1;
            int right = mid + 1 < mat[0].length ? mat[largestIdx][mid + 1] : -1;
            if (mat[largestIdx][mid] > left && mat[largestIdx][mid] > right) {
                return new int[]{largestIdx, mid};
            } else if (left > mat[largestIdx][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}