class Solution {
    public int countAsterisks(String s) {
        int count = 0, current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') current++;
            else if (current % 2 == 0 && s.charAt(i) == '*') count++;
        }
        return count;
    }
}