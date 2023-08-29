class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxi = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width;
                if (st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxi = Math.max(maxi, height * width);
            }
            st.push(i);
        }
        return maxi;
    }
}