class Solution {
    public void dfs(int node, int parent, int[] count, int[] res, ArrayList<ArrayList<Integer>> adj) {
        for (int children : adj.get(node)) {
            if (children == parent) {
                continue;
            }
            dfs(children, node, count, res, adj);
            count[node] += count[children];
            res[node] = res[node] + res[children] + count[children];
        }
    }
    
    public void dfs(int node, int parent, int[] count, int[] res, ArrayList<ArrayList<Integer>> adj, int N) {
        for (int children : adj.get(node)) {
            if (children == parent) {
                continue;
            }
            res[children] = res[node] - count[children] + (N - count[children]);
            dfs(children, node, count, res, adj, N);
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int count[] = new int[n], res[] = new int[n];
        
        Arrays.fill(count, 1);
        
        dfs(0, -1, count, res, adj);
        dfs(0, -1, count, res, adj, n);
        
        return res;
    }
}