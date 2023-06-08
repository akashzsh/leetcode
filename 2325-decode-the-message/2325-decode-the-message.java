class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        String result = "";
        char alphabet = 'a';
        for (char letter : key.toCharArray()) {
            if (letter != ' ' && !map.containsKey(letter))
                map.put(letter, alphabet++);
        }
        for (char letter : message.toCharArray()) {
            if (letter == ' ') result += ' ';
            else result += map.get(letter);
        }
        return result;
    }
}