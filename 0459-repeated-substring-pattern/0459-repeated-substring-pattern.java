class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String tmp = s + s;
        if (tmp.substring(1, tmp.length() - 1).contains(s)) return true;
        return false;
    }
}