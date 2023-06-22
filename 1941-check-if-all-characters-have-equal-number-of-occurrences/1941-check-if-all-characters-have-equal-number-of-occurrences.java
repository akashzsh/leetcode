class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] letters = new int[26];
        int check = 0;
        for (char letter : s.toCharArray()) {
            letters[letter - 'a']++;
            check = letters[letter - 'a'];
        }
        for (int i : letters) {
            if (i != 0 && i != check) return false;
        }
        return true;
    }
}