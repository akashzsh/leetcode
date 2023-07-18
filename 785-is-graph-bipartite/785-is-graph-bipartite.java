class Solution {
    public boolean dfs(int node, int c, int[][] graph, int[] color) {
        color[node] = c;
        for (int i = 0; i < graph[node].length; i++) {
            if (color[graph[node][i]] == -1) {
                if (!dfs(graph[node][i], 1 - c, graph, color)) return false;
            } else if (color[graph[node][i]] == color[node]) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        for (int i = 0; i < len; i++) color[i] = -1;
        for (int i = 0; i < len; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) return false;
            }
        }
        return true;
    }
}