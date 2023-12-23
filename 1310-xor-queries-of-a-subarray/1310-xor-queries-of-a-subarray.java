class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] ^ arr[i - 1];
        }
        n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int start = queries[i][0], end = queries[i][1];
            if (start == 0) {
                res[i] = arr[end];
            } else if (start >= 1) {
                res[i] = arr[start - 1] ^ arr[end];
            }
        }
        return res;
    }
}