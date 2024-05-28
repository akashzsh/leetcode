class Solution {
public:
    void f(int i, vector<int>& nums, vector<int>& ds, vector<vector<int>>& res, int n) {
        if (i == n) {
            res.push_back(ds);
            return;
        }
        
        ds.push_back(nums[i]);
        f(i + 1, nums, ds, res, n);
        ds.pop_back();
        f(i + 1, nums, ds, res, n);
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        
        vector<int> ds;
        
        f(0, nums, ds, res, nums.size());
        
        return res;
    }
};