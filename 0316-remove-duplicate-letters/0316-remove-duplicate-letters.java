class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];
        
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] seen = new boolean[26];
        
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            if (seen[cur]) continue;
            while (!st.isEmpty() && st.peek() > cur && last[st.peek()] > i) {
                seen[st.pop()] = false;
            }
            st.push(cur);
            seen[cur] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}