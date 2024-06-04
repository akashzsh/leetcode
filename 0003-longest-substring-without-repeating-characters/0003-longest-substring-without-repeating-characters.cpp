class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> mp;
        
        int res = 0;
        
        for (int left = 0, right = 0, n = s.size(); right < n; right++) {
            
            if (mp.find(s[right]) != mp.end()) {
                left = max(left, mp[s[right]] + 1);
            }
            
            mp[s[right]] = right;
            res = max(res, right - left + 1);
        }
        
        return res;
    }
};