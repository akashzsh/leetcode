class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[][] dp = new int[2001][2001];
    
    private boolean f(int i, int prev, int[] stones, int n) {
        if (i == n - 1) return true;
        if (dp[i][prev] != -1) return dp[i][prev] == 1;
        boolean ans = false;
        for (int next = prev - 1; next <= prev + 1; next++) {
            if (next > 0 && map.containsKey(stones[i] + next)) {
                ans = ans || f(map.get(stones[i] + next), next, stones, n);
            }
        }
        dp[i][prev] = ans ? 1 : 0;
        return ans;
    }
    
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int[] curRow : dp) Arrays.fill(curRow, -1);
        for (int i = 0; i < n; i++) map.put(stones[i] , i);
        return f(0, 0, stones, n);
    }
}