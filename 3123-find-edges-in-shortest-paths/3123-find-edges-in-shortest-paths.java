class Solution {
    void dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S, int[] cost) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[] {0, S});

        for (int i = 0; i < V; i++) {
            cost[i] = (int) (1e9);
        }

        cost[S] = 0;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            for (int[] neighbor : adj.get(cur[1])) {

                int node = neighbor[0];
                int weight = neighbor[1];

                if (cur[0] + weight < cost[node]) {
                    cost[node] = cur[0] + weight;
                    pq.add(new int[] {cost[node], node});
                }
            }
        }
    }
    
    public boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        // source to destination ---- destination to source
        int[] sToD = new int[n];
        int[] dToS = new int[n];
        
        dijkstra(n, adj, 0, sToD);
        dijkstra(n, adj, n - 1, dToS);
        
        // System.out.println(Arrays.toString(sToD));
        // System.out.println(Arrays.toString(dToS));
        
        boolean[] res = new boolean[edges.length];
        
        for (int k = 0; k < edges.length; k++) {
            int u = edges[k][0], v = edges[k][1], w = edges[k][2];
            
            // sToD[n - 1] contains the shortest path from 0 to n - 1
            if (sToD[u] + w + dToS[v] == sToD[n - 1]) {
                res[k] = true;
            }
            
            if (sToD[v] + w + dToS[u] == sToD[n - 1]) {
                res[k] = true;
            }
        }
        
        return res;
    }
}

// [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]