class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder tmp = new StringBuilder();
            for (char letter : word.toCharArray()) {
                tmp.append(MORSE[letter - 'a']);
            }
            set.add(tmp.toString());
        }
        return set.size();
    }
}