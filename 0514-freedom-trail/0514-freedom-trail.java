class Solution {
    public int distance(int i, int j, int N) {
        int clock = Math.abs(i - j);
        int aClock = N - clock;
        return Math.min(clock, aClock);
    }
    
    public int f(int ringIdx, int keyIdx, String ring, String key, int N, int[][] dp) {
        if (keyIdx == key.length()) {
            return 0;
        }
        
        if (dp[ringIdx][keyIdx] != -1) {
            return dp[ringIdx][keyIdx];
        }
        
        int res = 1_000_000_000;
        
        for (int i = 0; i < N; i++) {
            if (ring.charAt(i) == key.charAt(keyIdx)) {
                int cur = distance(ringIdx, i, N) + 1 + f(i, keyIdx + 1, ring, key, N, dp);
                res = Math.min(res, cur);
            }
        }
        
        return dp[ringIdx][keyIdx] = res;
    }
    
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][key.length()];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        return f(0, 0, ring, key, ring.length(), dp);
    }
}