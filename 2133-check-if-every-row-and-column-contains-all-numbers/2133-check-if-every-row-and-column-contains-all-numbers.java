class Solution {
    public boolean checkValid(int[][] matrix) {
        for (int row = 0, len = matrix.length; row < len; row++) {
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            for (int col = 0; col < len; col++) {
                if (!rows.add(matrix[row][col]) || !cols.add(matrix[col][row])) {
                    return false;
                }
            }
        }
        return true;
    }
}