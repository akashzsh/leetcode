class Solution {
    public String reversePrefix(String word, char ch) {
        char[] aux = word.toCharArray();
        int start = 0, last = 0;
        while (last < word.length() && word.charAt(last) != ch) last++;
        if (last == word.length()) return word;
        while (start < last) {
            char temp = aux[start];
            aux[start] = aux[last];
            aux[last] = temp;
            start++;
            last--;
        }
        return new String(aux);
    }
}