class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        
        vector<int> freq(26);
        
        for (auto& ch : s) {
            freq[ch - 'a']++;
        }
        
        for (auto& ch : t) {
            
            if (freq[ch - 'a'] <= 0) {
                return false;
            }
            
            freq[ch - 'a']--;
        }
        
        return true;
    }
};