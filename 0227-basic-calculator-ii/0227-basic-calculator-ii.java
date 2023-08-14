class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        int number = 0, result = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                number = number * 10 + (int)(curr - '0');
            }
            if ((!Character.isDigit(curr) && ' ' != curr) || i == len-1) {
                if (sign == '+') st.push(number);
                else if (sign == '-') st.push(-number);
                else if (sign == '*') st.push(st.pop() * number);
                else if (sign == '/') st.push(st.pop() / number);
                sign = curr;
                number = 0;
            }
        }
        for (int i : st) result += i;
        return result;
    }
}