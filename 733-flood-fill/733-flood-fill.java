class Solution {
    public void dfs(int[][] image, int sr, int sc, int ncolor, int scolor, int[] dx, int[] dy, int[][] ans) {
        ans[sr][sc] = ncolor;
        int rows = image.length, cols = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + dx[i], ncol = sc + dy[i];
            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && ans[nrow][ncol] == scolor && ans[nrow][ncol] != ncolor) {
                dfs(image, nrow, ncol, ncolor, scolor, dx, dy, ans);
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int scolor = image[sr][sc];
        int[][] ans = image;
        int[] delx = {-1, 0, 1, 0};
        int[] dely = {0, 1, 0, -1};
        dfs(image, sr, sc, color, scolor, delx, dely, ans);
        return ans;
    }
}