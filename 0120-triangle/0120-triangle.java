class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) prev[i] = triangle.get(n - 1).get(i);
        for (int row = n - 2; row >= 0; row--) {
            int[] curr = new int[row + 1];
            for (int col = 0; col <= row; col++) {
                int down = triangle.get(row).get(col) + prev[col];
                int diagonal = triangle.get(row).get(col) + prev[col + 1];
                curr[col] = Math.min(down, diagonal);
            }
            prev = curr;
        }
        return prev[0];
    }
}