class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int res = 0;
        for (char letter : s.toCharArray()) freq[letter - 'a']++;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (freq[i] != 0 && !set.add(freq[i])) {
                freq[i]--;
                res++;
            }
        }
        return res;
    }
}