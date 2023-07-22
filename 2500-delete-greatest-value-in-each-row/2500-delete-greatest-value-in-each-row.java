class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int len = grid.length, len2 = grid[0].length;
        for (int i = 0; i < len; i++) Arrays.sort(grid[i]);
        int ans = 0;
        for (int i = 0; i < len2; i++) {
            int max = 0;
            for (int j = 0; j < len; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}