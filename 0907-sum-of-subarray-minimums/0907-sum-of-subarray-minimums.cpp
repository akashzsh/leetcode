class Solution {
public:
    typedef long long ll;
    
    int sumSubarrayMins(vector<int>& arr) {
        constexpr int M = int(1e9) + 7;
        
        stack<int> st;
        ll res = 0;
        int n = arr.size();
        
        for (int k = 0; k <= n; k++) {
            while (!st.empty() && (k == n || arr[st.top()] > arr[k])) {
                int ls;
                int j = st.top(); st.pop();
                int i = st.empty() ? -1 : st.top();
                
                res = (res % M + (ll(arr[j]) * (k - j) * (j - i)) % M) % M;
            }
            st.push(k);
        }
        
        return int(res);
    }
};