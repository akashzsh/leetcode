class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String cur = countAndSay(n - 1);
        String res = "";
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);
            int cnt = 1;
            while (i < cur.length() - 1 && cur.charAt(i) == cur.charAt(i + 1)) {
                i++;
                cnt++;
            }
            res += Integer.toString(cnt) + ch;
        }
        return res;
    }
}