class Solution {
    public String freqAlphabets(String s) {
        int len = s.length();
        String result = "";
        for (int i = 0; i < len; i++) {
            if (i < len - 2 && s.charAt(i + 2) == '#') {
                int tmp = 96 + (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                result += (char) tmp;
                i += 2;
            } else result += (char) (96 + (s.charAt(i) - '0'));
        }
        return result;
    }
}