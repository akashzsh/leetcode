class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length(), flips = 0, cntOfOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cntOfOnes++;
            } else {
                flips = Math.min(flips + 1, cntOfOnes);
            }
        }
        return flips;
    }
}