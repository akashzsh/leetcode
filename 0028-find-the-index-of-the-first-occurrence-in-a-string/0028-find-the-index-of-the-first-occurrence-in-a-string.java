// Z Algorithm for Pattern Searching

class Solution {
    public void calculateZ(String s, int[] z, int n) {
        int l = 0, r = 0;
        for (int k = 1; k < n; k++) {
            if (k > r) {
                l = k;
                r = k;
                while (r < n && s.charAt(r) == s.charAt(r - l)) {
                    r++;
                }
                z[k] = r - l;
                r--;
            } else {
                int k1 = k - l;
                if (z[k1] < r - k + 1) {
                    z[k] = z[k1];
                } else {
                    l = k;
                    while (r < n && s.charAt(r) == s.charAt(r - l)) {
                        r++;
                    }
                    z[k] = r - l;
                    r--;
                }
            }
        }
    }
    
    public int strStr(String haystack, String needle) {
        int N = needle.length();
        String s = needle + "$" + haystack;
        
        int S = s.length();
        int[] z = new int[S];
        calculateZ(s, z, S);
        
        for (int i = 0; i < S; i++) {
            if (z[i] == N) {
                return i - N - 1;
            }
        }
        
        return -1;
    }
}