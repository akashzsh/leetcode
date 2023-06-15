class Solution {
    public boolean detectCapitalUse(String word) {
        char[] letters = word.toCharArray();
        int len = letters.length;
        int capital = 0;
        for (int i = 0; i < len; i++) {
            int curr = letters[i];
            if (curr <= 90) capital++;
        }
        if (capital == len || capital == 0) return true;
        capital = 0;
        for (int i = 0; i < len; i++) {
            int curr = letters[i];
            if (i != 0 && curr <= 90) return false;
        }
        return true;
    }
}