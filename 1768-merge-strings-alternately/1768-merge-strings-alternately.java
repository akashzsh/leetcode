class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, len1 = word1.length(), len2 = word2.length(), mod = 0;
        String result = "";
        while (i < len1 && j < len2) {
            if (mod % 2 == 0) result += word1.charAt(i++);
            else result += word2.charAt(j++);
            mod++;
        }
        while (i < len1) result += word1.charAt(i++);
        while (j < len2) result += word2.charAt(j++);
        return result;
    }
}