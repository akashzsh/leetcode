class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length, cnt = 0;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        for (int i = 0, j = 1; j < n; i++, j++) {
            cnt = Math.max(cnt, points[j][0] - points[i][0]);
        }
        return cnt;
    }
}