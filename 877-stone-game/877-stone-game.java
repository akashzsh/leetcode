class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int alice = 0, bob = 0, len = piles.length, i = 0;
        while (i < len) {
            alice += piles[i++];
            bob += piles[i++];
        }
        return alice < bob;
    }
}