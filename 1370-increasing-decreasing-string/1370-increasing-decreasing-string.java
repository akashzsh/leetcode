class Solution {
    private void construct(int[] freq, StringBuilder sb, boolean ascending) {
        for (int i = 0; i < 26; i++) {
            int j = ascending ? i : 25 - i;
            if (freq[j]-- > 0) sb.append((char)(j + 'a'));
        }
    }
    
    public String sortString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() != n) {
            construct(freq, sb, true);
            construct(freq, sb, false);
        }
        return sb.toString();
    }
}