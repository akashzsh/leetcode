class Solution {
    public boolean isPossible(int[] position, int dist, int m) {
        int curBalls = 1, last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                curBalls++;
                last = position[i];
            }
        }
        return curBalls >= m;
    }
    
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1, high = position[n - 1] - position[0];
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (isPossible(position, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}