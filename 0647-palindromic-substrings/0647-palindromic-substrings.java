class Solution {
    public int check(int center1, int center2, String s, int n) {
        int cnt = 0;
        while (center1 >= 0 && center2 < n && s.charAt(center1) == s.charAt(center2)) {
            cnt++;
            center1--;
            center2++;
        }
        return cnt;
    }
    
    public int countSubstrings(String s) {
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            res += check(i, i, s, n);
            res += check(i, i + 1, s, n);
        }
        return res;
    }
}