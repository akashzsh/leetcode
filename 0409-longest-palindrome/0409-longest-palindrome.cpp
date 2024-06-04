class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> mp;
        
        bool has_odd = false;
        
        for (auto& ch : s) {
            mp[ch]++;
        }
        
        int res = 0;
        
        for (auto& it : mp) {
            // cout << it.first << " and " << it.second << "\n";
            if (it.second & 1) {
                has_odd = true;
                break;
            }
        }
        
        for (auto& it : mp) {
            if ((it.second > 1) && (it.second & 1)) {
                res = res + (it.second - 1);
            } else if (!(it.second & 1)) {
                res = res + it.second;
            }
        }
        
        return has_odd ? res + 1 : res;
    }
};