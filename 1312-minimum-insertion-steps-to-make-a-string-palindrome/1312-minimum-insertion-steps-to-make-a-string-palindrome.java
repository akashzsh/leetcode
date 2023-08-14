class Solution {
    public int lps(String s, String t) {
        int r = s.length(), c = t.length();
        int[] prev = new int[c + 1];
        for (int i = 1; i <= r; i++) {
            int[] curr = new int[c + 1];
            for (int j = 1; j <= c; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[c];
    }
    
    public int minInsertions(String s) {
        return s.length() - lps(s, new StringBuilder(s).reverse().toString());
    }
}