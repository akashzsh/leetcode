class Solution {
    public String finalString(String s) {
        StringBuffer sb = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}