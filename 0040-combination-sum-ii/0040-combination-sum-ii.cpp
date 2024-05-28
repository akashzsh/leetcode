class Solution {
public:
    void f(int i, vector<int>& nums, vector<int>& ds, vector<vector<int>>& res, int target, int& N) {
        if (target == 0) {
            res.push_back(ds);
            return;
        }
        
        for (int j = i; j < N; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            if (nums[j] <= target) {
                ds.push_back(nums[j]);
                f(j + 1, nums, ds, res, target - nums[j], N);
                ds.pop_back();
            }
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& nums, int target) {
        int N = nums.size();
        
        vector<vector<int>> res;
        
        vector<int> ds;
        
        sort(nums.begin(), nums.end());
        
        f(0, nums, ds, res, target, N);
        
        return res;
    }
};