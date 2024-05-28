class Solution {
public:
    void f(int i, vector<int>& nums, vector<int>& ds, vector<vector<int>>& res, int& n, int target) {
        if (i == n) {
            if (target == 0) {
                res.push_back(ds);
            }
            return;
        }
        
        f(i + 1, nums, ds, res, n, target);
        
        if (nums[i] <= target) {
            ds.push_back(nums[i]);
            f(i, nums, ds, res, n, target - nums[i]);
            ds.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        int n = nums.size();
        
        vector<vector<int>> res;
        
        vector<int> ds;
        
        f(0, nums, ds, res, n, target);
        
        return res;
    }
};