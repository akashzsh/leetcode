class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0, j = tokens.length - 1, maxScore = 0, curScore = 0;
        Arrays.sort(tokens);
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                curScore++;
                maxScore = Math.max(maxScore, curScore);
                i++;
            } else if (curScore >= 1) {
                power += tokens[j];
                curScore--;
                j--;
            } else {
                return maxScore;
            }
        }
        return maxScore;
    }
}