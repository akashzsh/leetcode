class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        boolean centerUsed = false;
        int res = 0;
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                if (freq.getOrDefault(word, 0) >= 2) {
                    res += 4;
                    freq.put(word, freq.get(word) - 2);
                } else if (freq.getOrDefault(word, 0) == 1 && centerUsed == false) {
                    res += 2;
                    centerUsed = true;
                    freq.put(word, freq.get(word) - 1);
                }
            } else {
                if (freq.getOrDefault(word, 0) > 0 && freq.getOrDefault(reversed, 0) > 0) {
                    res += 4;
                    freq.put(word, freq.get(word) - 1);
                    freq.put(reversed, freq.get(reversed) - 1);
                }
            }
        }
        return res;
    }
}