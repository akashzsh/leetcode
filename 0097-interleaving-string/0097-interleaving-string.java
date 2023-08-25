class Solution {
    private boolean dfs(int i, int j, int k, char[] c1, char[] c2, char[] c3, boolean[][] isInvalid) {
        if (isInvalid[i][j]) return false;
        if (k == c3.length) return true;
        boolean valid = (i < c1.length && c1[i] == c3[k] && dfs(i + 1, j, k + 1, c1, c2, c3, isInvalid)) || (j < c2.length && c2[j] == c3[k] && dfs(i, j + 1, k + 1, c1, c2, c3, isInvalid));
        if (!valid) isInvalid[i][j] = true;
        return valid;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        char c1[] = s1.toCharArray(), c2[] = s2.toCharArray(), c3[] = s3.toCharArray();
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length()) return false;
        return dfs(0, 0, 0, c1, c2, c3, new boolean[n + 1][m + 1]);
    }
}