class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int i : piles) if (i > high) high = i;
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2, hours = 0;
            for (int i : piles) {
                hours += Math.ceil((double) i / (double) mid);
            }
            if (hours <= h) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else low = mid + 1;
        }
        return result;
    }
}