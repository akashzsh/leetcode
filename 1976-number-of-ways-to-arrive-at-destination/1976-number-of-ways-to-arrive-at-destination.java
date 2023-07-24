class Pair {
    int node;
    long dist;
    Pair (int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7), len = roads.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < len; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        long[] d = new long[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = Long.MAX_VALUE;
            w[i] = 0;
        }
        d[0] = 0;
        w[0] = 1;
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> (int)(x.dist - y.dist));
        q.offer(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (Pair it : adj.get(curr.node)) {
                if (curr.dist + it.dist < d[it.node]) {
                    d[it.node] = curr.dist + it.dist;
                    w[it.node] = w[curr.node];
                    q.offer(new Pair(it.node, d[it.node]));
                } else if (curr.dist + it.dist == d[it.node]) {
                    w[it.node] = (w[it.node] + w[curr.node]) % mod;
                }
            }
        }
        return w[n - 1] % mod;
    }
}