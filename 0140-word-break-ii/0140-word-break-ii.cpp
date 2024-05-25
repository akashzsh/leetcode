class Solution {
public:
    void f(int i, unordered_set<string>& dict, vector<string>& res, string cur, int& n, string& s) {
        if (i == n) {
            cur.pop_back();
            res.push_back(cur);
            return;
        }
        
        for (int j = i; j < n; j++) {
            string ck = s.substr(i, j - i + 1);
            if (dict.find(ck) != dict.end()) {
                f(j + 1, dict, res, cur + ck + " ", n, s);
            }
        }
    }
    
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        
        vector<string> res;
        
        int n = s.size();
        
        f(0, dict, res, "", n, s);
        
        return res;
    }
};