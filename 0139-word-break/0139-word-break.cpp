class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int N = s.size();
        unordered_set<string> sett(wordDict.begin(), wordDict.end());
        
        vector<bool> dp(N + 1);
        
        dp[N] = true;
        
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                string str = s.substr(i, j - i + 1);
                if (sett.find(str) != sett.end() && dp[j + 1]) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[0];
    }
};