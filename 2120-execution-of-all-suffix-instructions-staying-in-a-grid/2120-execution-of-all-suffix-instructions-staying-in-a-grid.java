class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] res = new int[len];
        int[] copy = Arrays.copyOfRange(startPos, 0, startPos.length);
        for (int i = 0; i < len; i++) {
            startPos = Arrays.copyOfRange(copy, 0, copy.length);
            for (int j = i; j < len; j++) {
                if (s.charAt(j) == 'R') {
                    if (++startPos[1] < n) res[i]++;
                    else break;
                }
                else if (s.charAt(j) == 'L') {
                    if (--startPos[1] >= 0) res[i]++;
                    else break;
                }
                else if (s.charAt(j) == 'U') {
                    if (--startPos[0] >= 0) res[i]++;
                    else break;
                }
                else if (s.charAt(j) == 'D') {
                    if (++startPos[0] < n) res[i]++;
                    else break;
                }
            }
        }
        return res;
    }
}