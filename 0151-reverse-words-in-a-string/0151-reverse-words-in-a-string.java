class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0 ; i--) {
            sb.append(parts[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}