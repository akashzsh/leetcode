class Solution {
    public String removeStars(String s) {
        int N = s.length();
        
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != '*') {
                stk.push(s.charAt(i));
            } else {
                if (stk.isEmpty()) {
                    break;
                }
                stk.pop();
            }
        }
        
        char[] res = new char[stk.size()];
        
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }
        
        return String.valueOf(res);
    }
}