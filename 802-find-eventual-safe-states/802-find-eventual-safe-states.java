class Solution {
    private boolean dfs(int node, int[] v, int[] pv, int[] check, int[][] graph) {
        v[node] = 1;
        pv[node] = 1;
        check[node] = 0;
        for (int i : graph[node]) {
            if (v[i] == 0) {
                if (dfs(i, v, pv, check, graph)) {
                    return true;
                }
            }
            else if (pv[i] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pv[node] = 0;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] v = new int[V];
        int[] pv = new int[V];
        int[] check = new int[V];
        for (int i = 0; i < V; i++) {
            if (v[i] == 0) dfs(i, v, pv, check, graph);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) res.add(i);
        }
        return res;
    }
}