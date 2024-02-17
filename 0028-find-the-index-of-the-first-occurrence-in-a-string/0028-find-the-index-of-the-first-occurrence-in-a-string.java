// Knuth–Morris–Pratt Algorithm

class Solution {
    public void calculateLPS(String pattern, int[] LPS) {
        int idx = 0, i = 1;
        while (i < LPS.length) {
            if (pattern.charAt(idx) == pattern.charAt(i)) {
                LPS[i] = idx + 1;
                idx++;
                i++;
            } else {
                if (idx != 0) {
                    idx = LPS[idx - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }
    
    public int strStr(String text, String pattern) {
        int T = text.length(), P = pattern.length();
        
        int[] LPS = new int[P];
        calculateLPS(pattern, LPS);
        System.out.println(Arrays.toString(LPS));
        
        int i = 0, j = 0;
        while (i < T) {
            if (j < P && text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == P) {
                    return i - P;
                }
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        if (j == P) {
            return i - P;
        }
        return -1;
    }
}