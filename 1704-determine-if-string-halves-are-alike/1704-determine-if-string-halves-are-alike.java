class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int i = 0, j = n / 2, cnt1 = 0, cnt2 = 0;
        while (j < n) {
            if (isVowel(s.charAt(i))) {
                cnt1++;
            }
            if (isVowel(s.charAt(j))) {
                cnt2++;
            }
            i++;
            j++;
        }
        return cnt1 == cnt2;
    }
}