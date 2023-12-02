class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for (char ch : chars.toCharArray()) {
            freq[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            int[] curFreq = new int[26];
            for (char ch : words[i].toCharArray()) {
                curFreq[ch - 'a']++;
            }
            byte flag = 1;
            for (byte j = 0; j < 26; j++) {
                if (freq[j] < curFreq[j]) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                ans += words[i].length();
            }
        }
        return ans;
    }
}