class Solution {
    
    public boolean isFeasible(int[] weights, int capacity, int threshold) {
        int currDays = 1, load = 0;
        for (int i : weights) {
            load += i;
            if (load > capacity) {
                currDays++;
                load = i;
            }
        }
        return currDays <= threshold;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int max = -1, sum = 0;
        for (int i : weights) {
            sum += i;
            if (i > max) {
                max = i;
            }
        }
        int left = max, right = sum, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isFeasible(weights, mid, days)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}