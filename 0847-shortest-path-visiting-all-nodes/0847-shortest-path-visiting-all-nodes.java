class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        int finalState = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i});
        }
        
        int[][] vis = new int[n][finalState + 1];
        int shortest = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            shortest++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int idx = cur[0];
                int curBit = cur[1];
                for (int neighbour : graph[idx]) {
                    int newBit = curBit | (1 << neighbour);
                    if (vis[neighbour][newBit] == 1) continue;
                    if (newBit == finalState) return shortest;
                    vis[neighbour][newBit] = 1;
                    q.offer(new int[]{neighbour, newBit});
                }
            }
        }
        return shortest;
    }
}