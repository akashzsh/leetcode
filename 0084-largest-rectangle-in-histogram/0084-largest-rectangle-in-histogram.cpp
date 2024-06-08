class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int res = 0;
        stack<int> st;
        
        for (int i = 0, n = heights.size(); i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.top()] >= heights[i])) {
                int l = heights[st.top()]; st.pop();
                int b = st.empty() ? i : i - st.top() - 1;
                res = max(res, l * b);
            }
            st.push(i);
        }
        
        return res;
    }
};