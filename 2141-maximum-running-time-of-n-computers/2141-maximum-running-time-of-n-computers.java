class Solution {
    private boolean isPossible(int[] batteries, int n, long mid) {
        long sum = 0, target = mid * n;
        for (int i = 0; i < batteries.length; i++) {
            sum += Math.min(mid, batteries[i]);
            if (sum >= target) return true;
        }
        return false;
    }
    
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int i : batteries) sum += i;
        long low = 0, high = sum;
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if (isPossible(batteries, n, mid)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}