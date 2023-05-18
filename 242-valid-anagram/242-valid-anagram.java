class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] frequency = new int[26];
        for (char letter : s.toCharArray()) frequency[letter - 'a']++;
        for (char letter : t.toCharArray())
            if (--frequency[letter - 'a'] < 0) return false;
        return true;
    }
}