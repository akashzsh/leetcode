class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.max(0, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }
        int taps = 0, curEnd = 0, nextEnd = 0;
        for (int i = 0; i <= n; i++) {
            if (i > nextEnd) return -1;
            if (i > curEnd) {
                taps++;
                curEnd = nextEnd;
            }
            nextEnd = Math.max(nextEnd, maxReach[i]);
        }
        return taps;
    }
}