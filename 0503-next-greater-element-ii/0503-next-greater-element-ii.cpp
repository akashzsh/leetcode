class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int N = nums.size();
        
        vector<int> nge(N);
        stack<int> st;
        
        for (int i = 2 * N - 1; i >= 0; i--) {
            while (!st.empty() && st.top() <= nums[i % N]) {
                st.pop();
            }
            nge[i % N] = st.empty() ? -1 : st.top();
            st.push(nums[i % N]);
        }
        
        return nge;
    }
};