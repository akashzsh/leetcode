class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length(), len2 = t.length(), i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == len1) return true;
        return false;
    }
}