// Space Optimization

class Solution {
    public int distance(int i, int j, int N) {
        int clock = Math.abs(i - j);
        int aClock = N - clock;
        return Math.min(clock, aClock);
    }
    
    public int findRotateSteps(String ring, String key) {
        int R = ring.length(), K = key.length();
        
        int prev[] = new int[R], cur[] = new int[R];
        
        for (int keyIdx = K - 1; keyIdx >= 0; keyIdx--) {
            for (int ringIdx = 0; ringIdx < R; ringIdx++) {
                int res = 1_000_000_000;
                for (int i = 0; i < R; i++) {
                    if (ring.charAt(i) == key.charAt(keyIdx)) {
                        int val = distance(ringIdx, i, R) + 1 + prev[i];
                        res = Math.min(res, val);
                    }
                }
                cur[ringIdx] = res;
            }
            System.arraycopy(cur, 0, prev, 0, R);
        }
        
        return prev[0];
    }
}

// Tabulation

/*
class Solution {
    public int distance(int i, int j, int N) {
        int clock = Math.abs(i - j);
        int aClock = N - clock;
        return Math.min(clock, aClock);
    }
    
    public int findRotateSteps(String ring, String key) {
        int R = ring.length(), K = key.length();
        
        int[][] dp = new int[R][K + 1];
        
        for (int keyIdx = K - 1; keyIdx >= 0; keyIdx--) {
            for (int ringIdx = 0; ringIdx < R; ringIdx++) {
                int res = 1_000_000_000;
                for (int i = 0; i < R; i++) {
                    if (ring.charAt(i) == key.charAt(keyIdx)) {
                        int cur = distance(ringIdx, i, R) + 1 + dp[i][keyIdx + 1];
                        res = Math.min(res, cur);
                    }
                }
                dp[ringIdx][keyIdx] = res;
            }
        }
        
        return dp[0][0];
    }
}
*/

// Recursion + Memoization

/*
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
*/