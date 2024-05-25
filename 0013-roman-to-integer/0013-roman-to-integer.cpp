class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> mp = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };
        
        int res = 0, n = s.size();
        
        for (int i = 0; i < n - 1; i++) {
            if (mp[s[i]] < mp[s[i + 1]]) {
                res = res - mp[s[i]];
            } else {
                res = res + mp[s[i]];
            }
        }
        
        res = res + mp[s[n - 1]];
        return res;
    }
};