class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, target = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++, target++) {
                result[top][i] = target;
            }
            top++;
            for (int i = top; i <= bottom; i++, target++) {
                result[i][right] = target;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--, target++) {
                    result[bottom][i] = target;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--, target++) {
                    result[i][left] = target;
                }
                left++;
            }
        }
        return result;
    }
}