class Solution {
public:
    string removeKdigits(string s, int k) {
        int n = s.size(), i = 0;
        
        if (n == k) {
            return "0";
        }
        
        stack<char> st;
        
        while (i < n && k > 0) {
            if (st.empty() || st.top() <= s[i]) {
                st.push(s[i]);
            } else {
                while (!st.empty() && k > 0 && st.top() > s[i]) {
                    k--;
                    st.pop();
                }
                st.push(s[i]);
            }
            i++;
        }
        
        while (i < n) {
            st.push(s[i]);
            i++;
        }
        
        while (k > 0) {
            st.pop();
            k--;
        }
        
        int x = st.size();
        
        vector<int> res(x);
        
        while (!st.empty()) {
            res[--x] = st.top(); st.pop();
        }
        
        int y = 0;
        while (y < res.size() && res[y] == '0') {
            y++;
        }
        
        string result(res.begin() + y, res.end());
        return result == "" ? "0" : result;
    }
};