class Solution {
    public boolean isValid(String s) {
        Stack<Character> box = new Stack<Character>();
        for (char x : s.toCharArray()) {
            if (x == '(') box.push(')');
            else if (x == '[') box.push(']');
            else if (x == '{') box.push('}');
            else if (box.isEmpty() || box.pop() != x) return false;
        }
        return box.isEmpty();
    }
}