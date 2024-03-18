class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int arrows = 1;
        int[] range = points[0];
        
        for (int i = 1; i < points.length; i++) {
            int prevStart = range[0], prevEnd = range[1];
            int curStart = points[i][0], curEnd = points[i][1];
            
            if (curStart > prevEnd) {
                arrows++;
                range = points[i];
            } else {
                range[0] = Math.max(prevStart, curStart);
                range[1] = Math.min(prevEnd, curEnd);
            }
        }
        
        return arrows;
    }
}