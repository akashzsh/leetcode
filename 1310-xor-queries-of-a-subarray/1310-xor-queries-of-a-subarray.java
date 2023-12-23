class Solution {
    private int f(int[] nums, int low, int high) {
        int xr = 0;
        for (int i = low; i <= high; i++) {
            xr = xr ^ nums[i];
        }
        return xr;
    }
    
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = f(arr, queries[i][0], queries[i][1]);
        }
        return res;
    }
}