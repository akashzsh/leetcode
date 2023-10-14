class Solution {
    int result = Integer.MAX_VALUE;
    
    private void solve(int idx, int[] cookies, int[] cur, int n, int k) {
        if (idx == n) {
            int max = 0;
            for (int i = 0; i < k; i++) if (cur[i] > max) max = cur[i];
            result = Math.min(result, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            cur[i] += cookies[idx];
            solve(idx + 1, cookies, cur, n, k);
            cur[i] -= cookies[idx];
        }
    }
    
    public int distributeCookies(int[] cookies, int k) {
        solve(0, cookies, new int[k], cookies.length, k);
        return result;
    }
}