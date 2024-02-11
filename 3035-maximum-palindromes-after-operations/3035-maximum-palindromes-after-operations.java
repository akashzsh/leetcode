class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] wordSizes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordSizes[i] = words[i].length();
        }
        Arrays.sort(wordSizes);
        Map < Character, Integer > freq = new HashMap < > ();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                freq.put(words[i].charAt(j), freq.getOrDefault(words[i].charAt(j), 0) + 1);
            }
        }
        int even = 0, odd = 0, res = 0;
        for (int i: freq.values()) {
            even = even + (i / 2);
            odd = odd + (i % 2);
        }
        for (int i = 0; i < words.length; i++) {
            if (wordSizes[i] % 2 != 0) {
                if (odd > 0) {
                    odd--;
                } else {
                    even--;
                    odd = odd + 2;
                    odd--;
                }
            }
            if (even < wordSizes[i] / 2) break;
            even -= wordSizes[i] / 2;
            res++;
        }
        return res;
    }
}