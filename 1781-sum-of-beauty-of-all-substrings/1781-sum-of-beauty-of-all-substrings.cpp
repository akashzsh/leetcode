class Solution {
public:
    int beautySum(string s) {
        int res = 0;
        
        for (int i = 0, n = s.size(); i < n; i++) {
            vector<int> freq(26);
            for (int j = i; j < n; j++) {
                freq[s[j] - 'a']++;
                
                int mini = INT_MAX, maxi = INT_MIN;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] == 0) {
                        continue;
                    }
                    
                    mini = min(mini, freq[k]);
                    maxi = max(maxi, freq[k]);
                }
            
                res = res + (maxi - mini);
            }
        }
        
        return res;
    }
};