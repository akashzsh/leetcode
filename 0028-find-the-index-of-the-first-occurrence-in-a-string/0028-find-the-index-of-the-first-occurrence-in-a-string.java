class Solution {
    public int rabinKarp(String text, String pattern) {
        int T = text.length(), P = pattern.length(), H = 1, d = 256;
        int tHash = 0, pHash = 0, prime = 101;

        for (int i = 0; i < P - 1; i++) {
            H = (d * H) % prime;
        }

        for (int i = 0; i < P; i++) {
            tHash = (d * tHash + text.charAt(i)) % prime;
            pHash = (d * pHash + pattern.charAt(i)) % prime;
        }

        for (int i = 0, j = 0; i <= T - P; i++) {
            if (tHash == pHash) {
                for (j = 0; j < P; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == P) {
                    return i;
                }
            }
            if (i < T - P) {
                tHash = (d * (tHash - text.charAt(i) * H) + text.charAt(i + P)) % prime;
                if (tHash < 0) {
                    tHash += prime;
                }
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        return rabinKarp(haystack, needle);
    }
}