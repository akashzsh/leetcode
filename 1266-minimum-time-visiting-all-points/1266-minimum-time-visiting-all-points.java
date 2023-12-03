class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int curX = points[i][0];
            int curY = points[i][1];
            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];
            ans += Math.max(Math.abs(targetX - curX), Math.abs(targetY - curY));
        }
        return ans;
    }
}