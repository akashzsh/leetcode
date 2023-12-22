class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zeros = new int[n];
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros[i] = zeros[i - 1] + 1;
            } else {
                zeros[i] = zeros[i - 1];
            }
        }
        zeros[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        int maxi = zeros[n - 1] + zeros[n - 2];
        for (int i = n - 2; i > 0; i--) {
            if (s.charAt(i) == '1') {
                zeros[i] = zeros[i + 1] + 1;
            } else {
                zeros[i] = zeros[i + 1];
            }
            maxi = Math.max(maxi, zeros[i] + zeros[i - 1]);
        }
        return maxi;
    }
}