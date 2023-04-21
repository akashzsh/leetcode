class Solution {
    public void rotate(int[][] matrix) {
        int currRow = 0, finalRow = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++, finalRow--) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[finalRow][j];
                matrix[finalRow][j] = temp;
            }
        }        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}