class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // byte experiment to save space (use int if there is confusion)
        byte[] inDegree = new byte[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] curr : roads) {
            inDegree[curr[0]]++;
            inDegree[curr[1]]++;
            connected[curr[0]][curr[1]] = true;
            connected[curr[1]][curr[0]] = true;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cnt = Math.max(cnt, inDegree[i] + inDegree[j] - (connected[i][j] == true ? 1 : 0));
            }
        }
        return cnt;
    }
}