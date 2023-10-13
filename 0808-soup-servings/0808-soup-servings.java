class Solution {
    private double aIsEmpty(int a, int b, ArrayList<int[]> op, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] != -1) return dp[a][b];
        double prob = 0.0;
        for (int[] i : op) {
            prob += aIsEmpty(a - i[0], b - i[1], op, dp);
        }
        return dp[a][b] = 0.25 * prob;
    }
    
    public double soupServings(int n) {
        if (n >= 9000) return 1;
        double[][] dp = new double[n + 1][n + 1];
        for (double[] i : dp) Arrays.fill(i, -1.0);
        ArrayList<int[]> op = new ArrayList<>();
        op.add(new int[]{100, 0});
        op.add(new int[]{75, 25});
        op.add(new int[]{50, 50});
        op.add(new int[]{25, 75});
        return aIsEmpty(n, n, op, dp);
    }
}