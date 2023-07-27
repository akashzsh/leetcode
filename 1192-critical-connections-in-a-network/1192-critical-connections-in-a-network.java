class Solution {
    private int timer = 1;
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, adj, vis, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node]) bridges.add(Arrays.asList(it, node));
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> it : connections) {
            adj.get(it.get(0)).add(it.get(1));
            adj.get(it.get(1)).add(it.get(0));
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, vis, tin, low, bridges);
        return bridges;
    }
}