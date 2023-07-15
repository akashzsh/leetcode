class Solution {
    public void dfs(int node, int[][] isConnected, boolean[] v) {
        v[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !v[i])
                dfs(i, isConnected, v);
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length, cnt = 0;
        boolean[] v = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!v[i]) {
                cnt++;
                dfs(i, isConnected, v);
            }
        }
        return cnt;
    }
}