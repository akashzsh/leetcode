class Solution {
    public boolean isOperator(String operator) {
        if (operator.length() != 1) {
            return false;
        }
        char op = operator.charAt(0);
        return op == '+' || op == '-' || op == '*' || op == '/';
    }
    
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (isOperator(tokens[i])) {
                int val2 = Integer.parseInt(stk.pop());
                int val1 = Integer.parseInt(stk.pop());
                int res;
                switch(tokens[i].charAt(0)) {
                    case '+':
                        res = val1 + val2;
                        break;
                    case '-':
                        res = val1 - val2;
                        break;
                    case '*':
                        res = val1 * val2;
                        break;
                    default:
                        res = val1 / val2;
                        break;
                }
                stk.push(Integer.toString(res));
            } else {
                stk.push(tokens[i]);
            }
        }
        return Integer.parseInt(stk.pop());
    }
}