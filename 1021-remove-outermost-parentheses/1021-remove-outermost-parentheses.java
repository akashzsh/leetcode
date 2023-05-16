class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0, close = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') close++;
            if (open == close) {
                result.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return result.toString();
    }
}