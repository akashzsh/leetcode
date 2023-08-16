class Solution {
    public int minDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m + 1];
        for (int i = 0; i <= m; i++) prev[i] = i;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j - 1], prev[j]));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}