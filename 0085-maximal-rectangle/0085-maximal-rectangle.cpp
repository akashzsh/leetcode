class Solution {
public:
    int largest_rectangle_in_histogram(vector<int>& nums) {
        stack<int> st;
        int res = 0;
        
        for (int i = 0, n = nums.size(); i <= n; i++) {
            while (!st.empty() && (i == n || nums[st.top()] >= nums[i])) {
                int height = nums[st.top()]; st.pop();
                int width = st.empty() ? i : i - st.top() - 1;
                res = max(res, height * width);
            }
            st.push(i);
        }
        
        return res;
    }
    
    int maximalRectangle(vector<vector<char>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<int> row(n);
        
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[j] = (grid[i][j] == '0') ? 0 : (row[j]) + (grid[i][j] - '0');
            }
            res = max(res, largest_rectangle_in_histogram(row));
        }
        
        return res;
    }
};