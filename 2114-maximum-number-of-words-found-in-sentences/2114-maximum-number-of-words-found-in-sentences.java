class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for (String currentSentence : sentences) {
            String[] result = currentSentence.split(" ");
            maxWords = result.length > maxWords ? result.length : maxWords;
        }
        return maxWords;
    }
}