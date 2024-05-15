class Solution {
public:
    void f(int i, string& s, unordered_set<string>& set, string cur, vector<string>& res) {
        if (i == s.size()) {
            cur.pop_back();
            res.push_back(cur);
            return;
        }
        
        for (int j = i; j < s.size(); j++) {
            string st = s.substr(i, j - i + 1);
            if (set.find(st) != set.end()) {
                f(j + 1, s, set, cur + st + " ", res);
            }
        }
    }
    
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> set(wordDict.begin(), wordDict.end());
        
        vector<string> res;
        
        f(0, s, set, "", res);
        
        return res;
    }
};