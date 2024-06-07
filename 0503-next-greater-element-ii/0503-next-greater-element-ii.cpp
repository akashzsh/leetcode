class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res(nums.size());
        stack<int> st;
        
        for (int n = nums.size(), i = 2 * n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.top() % n] <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                res[i] = st.empty() ? -1 : nums[st.top() % n];
            }
            st.push(i);
        }
        
        return res;
    }
};