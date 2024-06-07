class Solution {
public:
    vector<int> asteroidCollision(vector<int>& ast) {
        stack<int> st;
        
        for (auto& ball : ast) {
            while (!st.empty() && ball < 0 && st.top() > 0) {
                int sum = ball + st.top();
                
                if (sum > 0) {
                    ball = 0;
                } else if (sum < 0) {
                    st.pop();
                } else {
                    st.pop();
                    ball = 0;
                }
            }
            
            if (ball != 0) {
                st.push(ball);
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