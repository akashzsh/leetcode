class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] onesRow = new int[grid.length];
        int[] onesCol = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) onesRow[i]++;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) onesCol[i]++;
            }
        }
        int[][] diff = new int[grid.length][grid[0].length];
        for (int i = 0; i < diff.length; i++) {
            for (int j = 0; j < diff[i].length; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - (diff.length - onesRow[i]) - (diff[0].length - onesCol[j]);
            }
        }
        return diff;
    }
}