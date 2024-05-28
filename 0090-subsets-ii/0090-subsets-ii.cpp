class Solution {
public:
    void f(int i, vector<int>& nums, vector<int>& ds, vector<vector<int>>& res, int& N) {
        res.push_back(ds);
        
        for (int j = i; j < N; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            ds.push_back(nums[j]);
            f(j + 1, nums, ds, res, N);
            ds.pop_back();
        }
    }
    
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        int N = nums.size();
        
        sort(nums.begin(), nums.end());
        
        vector<vector<int>> res;
        
        vector<int> ds;
        
        f(0, nums, ds, res, N);
        
        return res;
    }
};