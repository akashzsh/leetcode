class Solution {
    private boolean check(int mid, int[] bloomDay, int m, int k) {
        int cnt = 0, res = 0;
        for (int i : bloomDay) {
            if (i <= mid) {
                cnt++;
            } else {
                res += (cnt / k);
                cnt = 0;
            }
        }
        res += (cnt / k);
        return res >= m;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length / m < k) return -1;
        int low = bloomDay[0], high = bloomDay[0];
        for (int i : bloomDay) {
            if (i < low) low = i;
            if (i > high) high = i;
        }
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (check(mid, bloomDay, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}