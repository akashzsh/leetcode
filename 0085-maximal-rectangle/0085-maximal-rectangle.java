class Solution {
    private int f(int n, int[] nums) {
        int maxi = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])) {
                int height = nums[st.pop()];
                int width;
                if (st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxi = Math.max(maxi, height * width);
            }
            st.push(i);
        }
        return maxi;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int nums[] = new int[m], maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') nums[j] += 1;
                else nums[j] = 0;
            }
            maxi = Math.max(maxi, f(m, nums));
        }
        return maxi;
    }
}