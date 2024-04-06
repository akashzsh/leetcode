class Solution {
    public String minRemoveToMakeValid(String s) {
        int N = s.length();
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stk = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                sb.append('$');
                stk.push(i);
            } else if (ch == ')') {
                if (!stk.isEmpty()) {
                    sb.setCharAt(stk.pop(), '(');
                    sb.append(')');
                } else {
                    sb.append('%');
                }
            } else {
                sb.append(ch);
            }
        }
        
        while (!stk.isEmpty()) {
            sb.deleteCharAt(stk.pop());
        }
        
        return sb.toString().replaceAll("%", "");
    }
}