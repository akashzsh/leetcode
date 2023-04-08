import java.util.HashMap;

class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> mapping = new HashMap<>();
        for (char letter : s.toCharArray()) {
            if (mapping.containsKey(letter)) return letter;
            mapping.put(letter, 1);
        }
        return 'a';
    }
}