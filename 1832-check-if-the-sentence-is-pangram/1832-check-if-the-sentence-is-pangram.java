class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> letters = new HashSet<>();
        for (char letter : sentence.toCharArray()) letters.add(letter);
        if (letters.size() == 26) return true;
        return false;
    }
}