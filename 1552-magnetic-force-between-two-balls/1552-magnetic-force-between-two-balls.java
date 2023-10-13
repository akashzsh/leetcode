class Solution {
    private boolean isPossible(int[] position, int mid, int m) {
        int cnt = 1, last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                cnt++;
                last = position[i];
            }
            if (cnt >= m) return true;
        }
        return false;
    }
    
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1, high = position[n - 1] - position[0];
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (isPossible(position, mid, m)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}