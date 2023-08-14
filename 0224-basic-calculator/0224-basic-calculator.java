class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        int result = 0, num = 0, sign = 1;
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                num = num * 10 + (int)(curr - '0');
            } else if (curr == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (curr == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (curr == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            } else if (curr == ')') {
                result += sign * num;
                num = 0;
                result *= st.pop();
                result += st.pop();
            }
        }
        if (num != 0) result += sign * num;
        return result;
    }
}