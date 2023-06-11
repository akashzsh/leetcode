class Solution {
    public int balancedStringSplit(String s) {
        int result = 0, curr = 0;
        for (int i = 0; i < s.length(); i++) {
            curr += s.charAt(i) == 'L' ? 1 : -1;
            if (curr == 0) result++;
        }
        return result;
    }
}