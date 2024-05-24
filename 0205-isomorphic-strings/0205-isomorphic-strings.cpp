class Solution {
public:
    bool isIsomorphic(string s, string t) {
        vector<int> m1(128), m2(128);
        
        for (int i = 0, n = s.size(); i < n; i++) {
            
            if (m1[s[i]] != m2[t[i]]) {
                return false;
            }
            
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        
        return true;
    }
};