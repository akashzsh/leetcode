class Solution {
    public String truncateSentence(String s, int k) {        
        int index = 0, space = 0, i = 0;
        while (space < k && i < s.length()) {
            index++;
            if (s.charAt(i++) == ' ') space++;
        }
        return i == s.length() ? s.substring(0, index) : s.substring(0, --index);
    }
}