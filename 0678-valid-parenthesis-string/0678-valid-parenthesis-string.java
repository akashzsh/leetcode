class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> stock = new Stack<>();
        
        int N = s.length();
        
        for (int i = 0; i < N; i++) {
            
            char ch = s.charAt(i);
            
            if (ch == '(') {
                stk.push(i);
            } else if (ch == '*') {
                stock.push(i);
            } else {
                if (stk.isEmpty()) {
                    if (stock.isEmpty() || stock.peek() > i) {
                        return false;
                    } else {
                        stock.pop();
                    }
                } else {
                    stk.pop();
                }
            }
            
        }
        
        if (!stk.isEmpty()) {
            while (!stk.isEmpty() && !stock.isEmpty()) {
                if (stk.peek() < stock.peek()) {
                    stk.pop();
                    stock.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stk.isEmpty();
    }
}