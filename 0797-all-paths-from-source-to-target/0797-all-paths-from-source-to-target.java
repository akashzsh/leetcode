class Solution {
    private void dfs(int node, int[][] graph, List<List<Integer>> res, List<Integer> ds) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(ds));
            return;
        }
        for (int adj : graph[node]) {
            ds.add(adj);
            dfs(adj, graph, res, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        ds.add(0);
        dfs(0, graph, res, ds);
        return res;
    }
}