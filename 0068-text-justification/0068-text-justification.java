class Solution {
    private List<String> getWords(int i, String[] words, int maxWidth, int len) {
        List<String> curLine = new ArrayList<>();
        int curLength = 0;
        while (i < len && curLength + words[i].length() <= maxWidth) {
            curLine.add(words[i]);
            curLength += words[i].length() + 1;
            i++;
        }
        return curLine;
    }
    
    private String createLine(List<String> curLine, int i, String[] words, int maxWidth, int len) {
        int baseLength = -1, curLineSize = curLine.size();
        for (String word : curLine) baseLength += word.length() + 1;
        int extraSpaces = maxWidth - baseLength;
        if (curLineSize == 1 || i == words.length) {
            return String.join(" ", curLine) + " ".repeat(extraSpaces);
        }
        int wordCount = curLineSize - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;
        for (int j = 0; j < needsExtraSpace; j++) {
            curLine.set(j, curLine.get(j) + " ");
        }
        for (int j = 0; j < wordCount; j++) {
            curLine.set(j, curLine.get(j) + " ".repeat(spacesPerWord));
        }
        return String.join(" ", curLine);
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, len = words.length;
        while (i < len) {
            List<String> curLine = getWords(i, words, maxWidth, len);
            i += curLine.size();
            res.add(createLine(curLine, i, words, maxWidth, len));
        }
        return res;
    }
}