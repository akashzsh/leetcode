class Solution {
    private int findDistance(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, sum = 0;
        HashSet<Integer> mst = new HashSet<>();
        mst.add(0);
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) dist[i] = findDistance(points, 0, i);
        while (mst.size() != n) {
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (mst.contains(i)) continue;
                if (next == -1 || dist[i] < dist[next]) next = i;
            }
            mst.add(next);
            sum += dist[next];
            for (int i = 0; i < n; i++) {
                if (mst.contains(i)) continue;
                dist[i] = Math.min(dist[i], findDistance(points, next, i));
            }
        }
        return sum;
    }
}