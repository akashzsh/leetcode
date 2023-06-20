class Solution {
    public int minSteps(String s, String t) {
        int[] alpha = new int[26];
        int len = s.length(), count = 0;
        for (int i = 0; i < len; i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) if (alpha[i] > 0) count += alpha[i];
        return count;
    }
}