class Solution {
    public int countHomogenous(String s) {
        int n = s.length(), streak = 0, M = (int) 1e9 + 7, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                streak++;
            } else {
                streak = 1;
            }
            ans = (ans + streak) % M;
        }
        return ans;
    }
}