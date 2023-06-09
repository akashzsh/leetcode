class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, len1 = word1.length(), len2 = word2.length();
        StringBuilder result = new StringBuilder();
        while (i < len1 || j < len2) {
            if (i < len1) result.append(word1.charAt(i++));
            if (j < len2) result.append(word2.charAt(j++));
        }
        return result.toString();
    }
}