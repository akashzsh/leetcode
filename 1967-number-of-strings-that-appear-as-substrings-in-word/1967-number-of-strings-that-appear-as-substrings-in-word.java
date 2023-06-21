class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) if (word.contains(pattern)) res++;
        return res;
    }
}