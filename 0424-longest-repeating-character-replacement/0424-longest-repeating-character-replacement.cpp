class Solution {
public:
    int characterReplacement(string s, int k) {
        int res = 0;
        
        vector<int> freq(26);
        
        for (int l = 0, r = 0, n = s.size(), mf = 0; r < n; r++) {
            freq[s[r] - 'A']++;
            
            mf = max(mf, freq[s[r] - 'A']);
            
            int del = (r - l + 1) - mf;
            
            if (del > k) {
                freq[s[l] - 'A']--;
                mf = max(mf, freq[s[l] - 'A']);
                l++;
            }
            
            res = max(res, r - l + 1);
        }
        
        return res;
    }
};