class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        unordered_map<int, int> mp;
        
        for (int l = 0, r = 0, n = s.size(); r < n; r++) {
            if (mp.find(s[r]) != mp.end()) {
                l = max(l, mp[s[r]] + 1);
            }
            
            mp[s[r]] = r;
            res = max(res, r - l + 1);
        }
        
        return res;
    }
};