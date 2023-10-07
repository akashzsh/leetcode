class Solution {
    int MOD = 1000000007;
    int[][][] dp = new int[51][51][101];
    int n, m, k;
    
    private int build(int idx, int searchCost, int maxSoFar) {
        if (idx == n) {
            if (searchCost == k) {
                return 1;
            }
            return 0;
        }
        
        if (dp[idx][searchCost][maxSoFar] != -1) {
            return dp[idx][searchCost][maxSoFar];
        }
        
        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (i > maxSoFar) {
                result = (result + build(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result + build(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }
        
        return dp[idx][searchCost][maxSoFar] = result % MOD;
    }
    
    public int numOfArrays(int N, int M, int K) {
        n = N;
        m = M;
        k = K;
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return build(0, 0, 0);
    }
}