class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] prevRow = new int[n];
        for (int row = 0; row < m; row++) {
            int[] curRow = matrix[row].clone();
            for (int col = 0; col < n; col++) {
                if (curRow[col] == 1) {
                    curRow[col] += prevRow[col];
                }
            }
            int[] sorted = curRow.clone();
            Arrays.sort(sorted);
            for (int i = n - 1; i >= 0; i--) {
                maxArea = Math.max(maxArea, (n - i) * (sorted[i]));
            }
            prevRow = curRow.clone();
        }
        return maxArea;
    }
}