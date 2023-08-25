class Solution {
    public String sortSentence(String str) {
        String[] words = str.split(" ");
        String[] ans = new String[words.length];
        for (String s : words) {
            int len = s.length();
            int index = Character.getNumericValue(s.charAt(len - 1)) - 1;
            ans[index] = s.substring(0, len - 1);
        }
        return String.join(" ", ans);
    }
}