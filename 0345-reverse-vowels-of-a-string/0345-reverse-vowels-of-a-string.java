class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    public String reverseVowels(String s) {        
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i < j) {
            if (isVowel(ch[i]) && isVowel(ch[j])) {
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
                i++;
                j--;
            } else {
                if (!isVowel(ch[i])) i++;
                if (!isVowel(ch[j])) j--;
            }
        }
        return String.valueOf(ch);
    }
}