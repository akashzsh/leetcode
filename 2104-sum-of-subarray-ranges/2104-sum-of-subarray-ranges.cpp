class Solution {
public:
    typedef long long ll;
    
    long long subArrayRanges(vector<int>& nums) {
        ll res = 0;
        stack<int> st;
        
        for (int k = 0, n = nums.size(); k <= n; k++) {
            while (!st.empty() && (k == n || nums[st.top()] > nums[k])) {
                int j = st.top(); st.pop();
                int i = st.empty() ? -1 : st.top();
                res -= ll(nums[j]) * (k - j) * (j - i);
            }
            st.push(k);
        }
        
        while (!st.empty()) st.pop();
        
        for (int k = 0, n = nums.size(); k <= n; k++) {
            while (!st.empty() && (k == n || nums[st.top()] < nums[k])) {
                int j = st.top(); st.pop();
                int i = st.empty() ? -1 : st.top();
                res += ll(nums[j]) * (k - j) * (j - i);
            }
            st.push(k);
        }
        
        return res;
    }
};