class Solution {
    public int maxCoins(int[] piles) {
        int res = 0, len = piles.length;
        Arrays.sort(piles);
        for (int i = len / 3; i < len; i += 2) res += piles[i];
        return res;
    }
}