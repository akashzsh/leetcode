class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] required = new int[n];
        for (int i = 0; i < n; i++) {
            required[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(required);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= required[i]) {
                cnt++;
                additionalRocks -= required[i];
            } else {
                break;
            }
        }
        return cnt;
    }
}