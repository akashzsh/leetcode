class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), ans[] = new int[n];
        for (int i = 0, cnt = 0, ops = 0; i < n; i++) {
            ans[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        for (int i = n - 1, cnt = 0, ops = 0; i >= 0; i--) {
            ans[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        return ans;
    }
}