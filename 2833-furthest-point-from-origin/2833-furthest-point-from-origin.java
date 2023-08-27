class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lc = 0, rc = 0, uc = 0;
        for (char m : moves.toCharArray()) {
            if (m == 'L') lc++;
            else if (m == 'R') rc++;
            else uc++;
        }
        return Math.abs(lc - rc) + uc;
    }
}