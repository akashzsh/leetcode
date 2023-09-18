class Solution {
    private int countOnes(int[] arr) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{countOnes(mat[i]), i});
            if (q.size() > k) q.poll();
        }
        while (k > 0) ans[--k] = q.poll()[1];
        return ans;
    }
}