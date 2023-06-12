class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char letter : columnTitle.toCharArray()) {
            int d = letter - 'A' + 1;
            result = result * 26 + d;
        }
        return result;
    }
}