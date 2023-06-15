class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        for (char letter : s.toCharArray()) {
            int curr = letter;            
            if (curr >= 65 && curr <= 90) result.append((char)(letter + 32));
            else result.append(letter);
        }
        return result.toString();
    }
}