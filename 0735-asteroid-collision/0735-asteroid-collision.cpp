class Solution {
public:
    vector<int> asteroidCollision(vector<int>& ast) {
        stack<int> st;
        
        for (int& cur : ast) {
            while (!st.empty() && cur < 0 && st.top() > 0) {
                
                int sum = cur + st.top();
                
                if (sum < 0) {
                    st.pop();
                } else if (sum > 0) {
                    cur = 0;
                } else {
                    st.pop();
                    cur = 0;
                }
            }
            
            if (cur != 0) {
                st.push(cur);
            }
        }
        
        int k = st.size();
        vector<int> res(k);
        
        while (!st.empty()) {
            res[--k] = st.top(); st.pop();
        }
        
        return res;
    }
};