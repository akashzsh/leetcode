class Solution {
    public String removeKdigits(String s, int k) {
        int N = s.length();
        
        if (k == N) {
            return "0";
        }
        
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            
            while (!stk.isEmpty() && k > 0 && stk.peek() > s.charAt(i)) {
                stk.pop();
                k--;
            }
            
            stk.push(s.charAt(i));
        }
        
        while (!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }
        
        char[] res = new char[stk.size()];
        
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }
        
        k = 0;
        
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0') {
                k++;
            } else {
                break;
            }
        }
        
        if (k == res.length) {
            return "0";
        }
        
        return new String(res, k, res.length - k);
    }
}