class Solution {
    public String replaceDigits(String s) {
        int len = s.length();
        char[] input = s.toCharArray();
        for (int i = 1; i < len; i += 2) {
            input[i] += input[i - 1] - '0';
        }
        return new String(input);
    }
}