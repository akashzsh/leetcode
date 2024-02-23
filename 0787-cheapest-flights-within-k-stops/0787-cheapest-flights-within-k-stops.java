class Pair {
    int node;
    int dist;
    Pair (int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Tuple {
    int stops;
    int node;
    int dist;
    Tuple (int stops, int node, int dist) {
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Tuple> q = new LinkedList<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int len = flights.length;
        for (int i = 0; i < len; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = (int)(1e9);
        d[src] = 0;
        q.offer(new Tuple(0, src, 0));
        while (!q.isEmpty()) {
            Tuple c = q.poll();
            int stops = c.stops, node = c.node, dist = c.dist;
            if (stops > k) continue;
            for (Pair i : adj.get(node)) {
                if (dist + i.dist < d[i.node] && stops <= k) {
                    d[i.node] = dist + i.dist;
                    q.offer(new Tuple(stops + 1, i.node, d[i.node]));
                }
            }
        }
        if (d[dst] == (int)(1e9)) return -1;
        return d[dst];
    }
}