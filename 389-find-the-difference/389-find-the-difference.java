class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char letter : s.toCharArray()) result ^= letter;
        for (char letter : t.toCharArray()) result ^= letter;
        return result;
    }
}