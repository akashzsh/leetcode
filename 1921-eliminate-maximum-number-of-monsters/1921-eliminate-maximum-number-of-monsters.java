class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] arrivals = new double[n];
        for (int i = 0; i < n; i++) {
            arrivals[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(arrivals);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arrivals[i] <= i) {
                break;
            }
            ans++;
        }
        return ans;
    }
}