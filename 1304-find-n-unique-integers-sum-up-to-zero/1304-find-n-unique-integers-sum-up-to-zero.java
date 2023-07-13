class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = 2 * i - n + 1;
        return res;
    }
}