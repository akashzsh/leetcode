class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        char[] res = new char[ch.length + 1];
        
        int i = ch.length - 1, m = 0;
        while (i >= 0) {
            while (i >= 0 && ch[i] == ' ') {
                i--;
            }
            if (i < 0) break;
            int j = i;
            while (i >= 0 && ch[i] != ' ') {
                i--;
            }
            for (int k = i + 1; k <= j; k++) {
                res[m++] = ch[k];
            }
            res[m++] = ' ';
        }
        return new String(res, 0, m - 1);
    }
}