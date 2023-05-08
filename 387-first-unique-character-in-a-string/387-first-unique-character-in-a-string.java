class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char letter : s.toCharArray()) {
            if (count.containsKey(letter)) count.put(letter, count.get(letter) + 1);
            else count.put(letter, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}