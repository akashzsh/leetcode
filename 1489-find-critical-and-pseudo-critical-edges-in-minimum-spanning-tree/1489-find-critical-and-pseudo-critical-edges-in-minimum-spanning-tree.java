class Pair {
    int v;
    int dist;
    Pair (int dist, int v) {
        this.v = v;
        this.dist = dist;
    }
}

class Solution {
    public int findDistance(ArrayList<ArrayList<Pair>> adj, int S, int D) {
        int V = adj.size();
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e9);
        dist[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pq.offer(new Pair(0, S));
        while (!pq.isEmpty()) {
            int currNode = pq.peek().v;
            int dis = pq.peek().dist;
            pq.poll();
            if (-dis > dist[currNode]) continue;
            for (Pair i : adj.get(currNode)) {
                int v = i.v;
                int d = i.dist;
                if (currNode == S && v == D) continue;
                if (Math.max(dist[currNode], d) < dist[v]) {
                    dist[v] = Math.max(dist[currNode], d);
                    pq.offer(new Pair(-dist[v], v));
                }
            }
        }
        return dist[D];
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < len; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) res.add(new ArrayList<>());
        for (int i = 0; i < len; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            int m = findDistance(adj, u, v);
            if (w < m) res.get(0).add(i);
            else if (w == m) res.get(1).add(i);
        }
        return res;
    }
}