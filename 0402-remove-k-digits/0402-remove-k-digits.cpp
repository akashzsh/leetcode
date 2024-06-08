class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();
        
        if (n == k) {
            return "0";
        }
        
        int i = 0;
        stack<int> st;
        
        while (i < n && k > 0) {
            if (st.empty() || st.top() <= num[i]) {
                st.push(num[i]);
            } else {
                while (!st.empty() && k > 0 && st.top() > num[i]) {
                    k--;
                    st.pop();
                }
                st.push(num[i]);
            }
            i++;
        }
        
        while (i < n) {
            st.push(num[i]);
            i++;
        }
        
        while (k > 0) {
            st.pop();
            k--;
        }
        
        k = st.size();
        vector<int> vt(k);
        
        while (!st.empty()) {
            vt[--k] = st.top(); st.pop();
        }
        
        int y = 0;
        while (y < vt.size() && vt[y] == '0') {
            y++;
        }
        
        string s(vt.begin() + y, vt.end());
        
        return s == "" ? "0" : s;
    }
};