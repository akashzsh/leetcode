class Solution {
    public boolean dfs(int node, int[] v, int[] pv, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        v[node] = 1;
        pv[node] = 1;
        for (int i : adj.get(node)) {
            if (v[i] == 0) {
                if (dfs(i, v, pv, st, adj)) return true;
            } else if (pv[i] == 1) return true;
        }
        st.push(node);
        pv[node] = 0;
        return false;
    }
    
    public int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] v = new int[V], pv = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (v[i] == 0) dfs(i, v, pv, st, adj);
        }
        if (st.size() != V) return new int[] {};
        int[] res = new int[V];
        int k = 0;
        while (!st.isEmpty()) res[k++] = st.pop();
        return res;
    }
}