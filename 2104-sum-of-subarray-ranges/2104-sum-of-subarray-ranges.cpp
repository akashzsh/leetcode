class Solution {
public:
    typedef long long ll;
    
    long long subArrayRanges(vector<int>& nums) {
        int n = nums.size();
        stack<int> st;
            
        ll res = 0;
        
        for (int k = n - 1; k >= -1; k--) {
            while (!st.empty() && (k == -1 || nums[st.top()] < nums[k])) {
                int j = st.top(); st.pop();
                int i = st.empty() ? n : st.top();
                res += ll(nums[j]) * (i - j) * (j - k);
            }
            st.push(k);
        }
        
        st = stack<int>();
        
        for (int k = 0; k <= n; k++) {
            while (!st.empty() && (k == n || nums[st.top()] > nums[k])) {
                int j = st.top(); st.pop();
                int i = st.empty() ? -1 : st.top();
                res -= ll(nums[j]) * (k - j) * (j - i);
            }
            st.push(k);
        }
        
        return res;
    }
};