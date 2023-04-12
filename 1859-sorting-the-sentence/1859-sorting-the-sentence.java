class Solution {
    public String sortSentence(String s) {
        HashMap<Character, String> mapping = new HashMap<>();
        String[] result = s.split(" ");
        for (int i = 0; i < result.length; i++) {
            mapping.put(result[i].charAt(result[i].length() - 1), result[i].substring(0, result[i].length() - 1));
        }
        s = "";
        for (int i = 1; i <= result.length; i++, s += ' ') {
            s += mapping.get(Character.forDigit(i, 10));
        }
        return s.substring(0, s.length() - 1);
    }
}