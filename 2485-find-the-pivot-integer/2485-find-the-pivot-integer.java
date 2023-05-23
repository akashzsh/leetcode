class Solution {
    public int pivotInteger(int n) {
        int eq = (n * n + n) / 2;
        int sq = (int) Math.sqrt(eq);
        if (sq * sq == eq) return sq;
        return - 1;
    }
}