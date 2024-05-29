// 1 -> true
// 2 -> false

class Solution {
public:
    int f(int i, string& s, unordered_set<string>& sett, int& N, vector<int>& dp) {
        if (i == N) {
            return 1;
        }
        
        if (dp[i] != -1) {
            return dp[i];
        }
        
        for (int j = i; j < N; j++) {
            string str = s.substr(i, j - i + 1);
            if (sett.find(str) != sett.end() && f(j + 1, s, sett, N, dp) == 1) {
                return dp[i] = 1;
            }
        }
        
        return dp[i] = 2;
    }
    
    bool wordBreak(string s, vector<string>& wordDict) {
        int N = s.size();
        unordered_set<string> sett(wordDict.begin(), wordDict.end());
        
        vector<int> dp(N + 1, -1);
        
        return f(0, s, sett, N, dp) == 1 ? true : false;
    }
};