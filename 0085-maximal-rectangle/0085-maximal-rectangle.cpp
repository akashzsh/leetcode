class Solution {
public:
    int largest_rectangle_in_histogram(vector<int>& nums) {
        int res = 0;
        stack<int> st;
        
        // for (auto& it : nums) cout << it << " ";
        // cout << "\n";
        
        for (int i = 0, n = nums.size(); i <= n; i++) {
            while (!st.empty() && (i == n || nums[st.top()] >= nums[i])) {
                int h = nums[st.top()]; st.pop();
                int w = st.empty() ? i : i - st.top() - 1;
                res = max(res, h * w);
            }
            st.push(i);
        }
        
        return res;
    }
    
    int maximalRectangle(vector<vector<char>>& matrix) {
        vector<int> nums(matrix[0].size());
        int res = 0;
        
        for (int i = 0, m = matrix.size(), n = matrix[0].size(); i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[j] = matrix[i][j] == '0' ? 0 : nums[j] + 1;
            }
            res = max(res, largest_rectangle_in_histogram(nums));
        }
        
        return res;
    }
};