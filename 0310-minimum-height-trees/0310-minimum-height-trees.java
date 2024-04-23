class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] degree = new int[n];
        
        for (int[] edge : edges) {
            
            // construct graph
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            
            // note indegree
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        // start removing leaf nodes
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        
        // only 2 nodes or 1 node remain-- (base case)
        // for 2 nodes height will be 2, for 1 node height will be 1
        while (n > 2) {
            int sz = q.size();
            n = n - sz;
            
            while (sz > 0) {
                
                int cur = q.poll();
                
                for (int neighbor : adj.get(cur)) {
                    degree[neighbor]--;
                    
                    if (degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
                
                sz--;
            }
        }
        
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        
        return res;
    }
}