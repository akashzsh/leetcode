class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(), strs.end());
        
        string s = strs[0], t = strs[strs.size() - 1];
        
        string res;
        
        for (int i = 0, n = min(s.size(), t.size()); i < n; i++) {
            if (s[i] != t[i]) break;
            res = res + s[i];
        }
        
        return res;
    }
};