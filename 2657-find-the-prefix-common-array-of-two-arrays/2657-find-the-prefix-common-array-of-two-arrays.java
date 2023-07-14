class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] run = new int[len + 1];
        int[] ans = new int[len];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            run[A[i]]++;
            if (run[A[i]] == 2) cnt++;
            run[B[i]]++;
            if (run[B[i]] == 2) cnt++;
            ans[i] = cnt;
        }
        return ans;
    }
}