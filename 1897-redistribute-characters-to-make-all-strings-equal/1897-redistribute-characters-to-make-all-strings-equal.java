class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if (n == 1) {
            return true;
        }
        int[] freq = new int[26];
        for (String cur : words) {
            for (char ch : cur.toCharArray()) {
                freq[ch - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                if (freq[i] % n != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}