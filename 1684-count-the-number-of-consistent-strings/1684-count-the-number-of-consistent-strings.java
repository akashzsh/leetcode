class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashMap<Character, Integer> letters = new HashMap<>();
        for (char letter : allowed.toCharArray()) {
            if (!letters.containsKey(letter)) letters.put(letter, 1);
        }
        for (String word : words) {
            boolean check = true;
            for (char letter : word.toCharArray()) {
                if (!letters.containsKey(letter)) check = false;
            }
            if (check) count++;
        }
        return count;
    }
}