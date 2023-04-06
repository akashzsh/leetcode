class Solution {
    
    public boolean checkVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public int vowelStrings(String[] words, int left, int right) {        
        int count = 0;
        for (int i = left; i <= right; i++)
            if (checkVowel(words[i].charAt(0)) && checkVowel(words[i].charAt(words[i].length() - 1))) count++;
        return count;
    }
}