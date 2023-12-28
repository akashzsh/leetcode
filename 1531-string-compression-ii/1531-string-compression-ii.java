class Solution {
    private int solve(String s, int n, int i, int prev, int freq, int k, int[][][][] dp) {
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        
        if (i >= n) {
            return 0;
        }
        
        if (dp[i][prev][freq][k] != -1) {
            return dp[i][prev][freq][k];
        }
        
        int deleteI = solve(s, n, i + 1, prev, freq, k - 1, dp);
        
        int keepI = 0;
        if (s.charAt(i) - 'a' != prev) {
            keepI = 1 + solve(s, n, i + 1, s.charAt(i) - 'a', 1, k, dp);
        } else {
            int oneAdd = 0;
            if (freq == 1 || freq == 9 || freq == 99) {
                oneAdd++;
            }
            keepI = oneAdd + solve(s, n, i + 1, s.charAt(i) - 'a', freq + 1, k, dp);
        }
        
        return dp[i][prev][freq][k] = Math.min(deleteI, keepI);
    }
    
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][][][] dp = new int[n + 1][27][n + 1][k + 1];
        for (int[][][] d1 : dp) {
            for (int[][] d2 : d1) {
                for (int[] d3 : d2) {
                    Arrays.fill(d3, -1);
                }
            }
        }
        return solve(s, n, 0, 26, 0, k, dp);
    }
}