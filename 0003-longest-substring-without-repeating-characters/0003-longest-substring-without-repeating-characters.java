class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), max = 0;
        HashMap<Character, Integer> record = new HashMap<>();
        for (int i = 0, j = 0; i < len; i++) {
            char letter = s.charAt(i);
            if (record.containsKey(letter)) {
                j = Math.max(j, record.get(letter) + 1);
            }
            record.put(letter, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}