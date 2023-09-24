class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glass = new double[102][102];
        glass[0][0] = (double) poured;
        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                double tmp = (glass[row][col] - 1) / 2;
                if (tmp > 0) {
                    glass[row + 1][col] += tmp;
                    glass[row + 1][col + 1] += tmp;
                }
            }
        }
        return Math.min(1, glass[query_row][query_glass]);
    }
}