class Solution {
public:
    bool is_palindrome(string& s, int low, int high) {
        while (low < high) {
            if (s[low] != s[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    
    void f(int i, string& s, vector<vector<string>>& res, int& n, vector<string>& ds) {
        if (i == n) {
            res.push_back(ds);
            return;
        }
        
        for (int j = i; j < n; j++) {
            if (is_palindrome(s, i, j)) {
                ds.push_back(s.substr(i, j - i + 1));
                f(j + 1, s, res, n, ds);
                ds.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        int n = s.size();
        
        vector<vector<string>> res;
        
        vector<string> ds;
        
        f(0, s, res, n, ds);
        
        return res;
    }
};