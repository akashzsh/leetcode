class Solution {
    public void dfs(int i, int j, int[][] land, boolean[][] vis, int[] maxi, int[] dr, int[] dc) {
        vis[i][j] = true;
        maxi[0] = Math.max(maxi[0], i);
        maxi[1] = Math.max(maxi[1], j);
        
        for (int k = 0; k < 4; k++) {
            int ni = i + dr[k], nj = j + dc[k];
            if (ni >= 0 && ni < land.length && nj >= 0 && nj < land[0].length && land[ni][nj] == 1 && !vis[ni][nj]) {
                dfs(ni, nj, land, vis, maxi, dr, dc);
            }
        }
    }
    
    public int[][] findFarmland(int[][] land) {
        int R = land.length, C = land[0].length;
        boolean[][] vis = new boolean[R][C];
        
        ArrayList<int[]> vec = new ArrayList<>();
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] maxi = new int[2];
                if (land[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, land, vis, maxi, dr, dc);
                    vec.add(new int[]{i, j, maxi[0], maxi[1]});
                }
            }
        }
        
        int[][] res = new int[vec.size()][4];
        
        for (int i = 0; i < res.length; i++) {
            res[i][0] = vec.get(i)[0];
            res[i][1] = vec.get(i)[1];
            res[i][2] = vec.get(i)[2];
            res[i][3] = vec.get(i)[3];
        }
        
        return res;
    }
}