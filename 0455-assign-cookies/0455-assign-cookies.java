class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length, i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }
}