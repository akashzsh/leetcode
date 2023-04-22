class Solution {
    public int lengthOfLastWord(String s) {
        int tail = s.length() - 1, len = 0;
        while (tail >= 0 && s.charAt(tail) == ' ') tail--;
        while (tail >= 0 && s.charAt(tail) != ' ') {
            len++;
            tail--;
        }
        return len;
    }
}