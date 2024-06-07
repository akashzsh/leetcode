class Solution {
public:
    typedef long long ll;
    
    int sumSubarrayMins(vector<int>& arr) {
        int M = int(1e9) + 7;
        stack<int> st;
        
        ll res = 0;
        
        for (int k = 0, n = arr.size(); k <= n; k++) {
            while (!st.empty() && (k == n || arr[st.top()] > arr[k])) {
                int j = st.top(); st.pop();
                int i = st.empty() ? -1 : st.top();
                res = ((res % M) + ll(arr[j]) * (k - j) * (j - i) % M) % M;
            }
            st.push(k);
        }
        
        return int(res);
    }
};