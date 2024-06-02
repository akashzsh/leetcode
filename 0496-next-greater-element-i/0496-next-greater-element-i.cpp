class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> nge;
        stack<int> st;
        
        for (int i = nums2.size() - 1; i >= 0; i--) {
            while (!st.empty() && st.top() <= nums2[i]) {
                st.pop();
            }
            nge[nums2[i]] = st.empty() ? -1 : st.top();
            st.push(nums2[i]);
        }
        
        vector<int> res(nums1.size());
        
        for (int i = 0, n = nums1.size(); i < n; i++) {
            res[i] = nge[nums1[i]];
        }
        
        return res;
    }
};