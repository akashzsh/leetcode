class DisjointSet {
    int[] rank;
    int[] parent;
    
    DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }
    
    int findUParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUParent(parent[node]);
    }
    
    void unionByRank(int u, int v) {
        int ulp_u = findUParent(u), ulp_v = findUParent(v);
        
        if (ulp_u == ulp_v) {
            return;
        }
        
        if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else if (rank[ulp_v] > rank[ulp_u]) {
            parent[ulp_u] = ulp_v;
        } else {
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);
        
        for (int[] edge : edges) {
            if (ds.findUParent(edge[0]) != ds.findUParent(edge[1])) {
                ds.unionByRank(edge[0], edge[1]);
            }
        }
        
        return ds.findUParent(source) == ds.findUParent(destination);
    }
}