class Solution {
public:
    void f(int lc, int rc, int& n, string ds, vector<string>& res) {
        if (ds.size() == (n << 1)) {
            res.push_back(ds);
            return;
        }
        
        if (lc < n) {
            f(lc + 1, rc, n, ds + "(", res);
        }
        
        if (lc > rc) {
            f(lc, rc + 1, n, ds + ")", res);
        }
    }
    
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        
        f(0, 0, n, "", res);
        
        return res;
    }
};