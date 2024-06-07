class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        stack<int> st;
        unordered_map<int, int> mp;
        
        for (int i = nums2.size() - 1; i >= 0; i--) {
            while (!st.empty() && nums2[st.top()] <= nums2[i]) {
                st.pop();
            }
            mp[nums2[i]] = st.empty() ? -1 : nums2[st.top()];
            st.push(i);
        }
        
        vector<int> res(nums1.size());
        
        for (int i = 0, n = nums1.size(); i < n; i++) {
            res[i] = mp[nums1[i]];
        }
        
        return res;
    }
};