class Solution {
    public int partitionString(String s) {
        int n = s.length(), i = 0, curBit = 0, cnt = 1;
        while (i < n) {
            int cur = s.charAt(i) - 'a';
            if ((curBit & (1 << cur)) != 0) {
                curBit = 0;
                cnt++;
            }
            curBit = curBit | (1 << cur);
            i++;
        }
        return cnt;
    }
}