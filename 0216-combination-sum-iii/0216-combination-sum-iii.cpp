class Solution {
public:
    void f(int i, int target, int& size, vector<int>& ds, vector<vector<int>>& res) {
        if (i == 10) {
            if (target == 0 && ds.size() == size) {
                res.push_back(ds);
            }
            return;
        }
        
        f(i + 1, target, size, ds, res);
        if (i <= target) {
            ds.push_back(i);
            f(i + 1, target - i, size, ds, res);
            ds.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        
        vector<int> ds;
        
        f(1, n, k, ds, res);
        
        return res;
    }
};