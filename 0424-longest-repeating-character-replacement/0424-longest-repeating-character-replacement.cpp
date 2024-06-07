class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> ht(26);
        int res = 0;
        
        for (int l = 0, r = 0, n = s.size(), mf = INT_MIN; r < n; r++) {
            ht[s[r] - 'A']++;
            mf = max(mf, ht[s[r] - 'A']);
            
            int diff = (r - l + 1) - mf;
            
            while (diff > k) {
                ht[s[l] - 'A']--;
                diff--;
                l++;
            }
            
            res = max(res, r - l + 1);
        }
        
        return res;
    }
};