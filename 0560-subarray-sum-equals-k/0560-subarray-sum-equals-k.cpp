class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> mpp;
        
        mpp[0] = 1;
        
        int res = 0;
        
        for (int i = 0, n = nums.size(), cur = 0; i < n; i++) {
            
            cur = cur + nums[i];
            
            if (mpp.find(cur - k) != mpp.end()) {
                res = res + mpp[cur - k];
            }
            
            mpp[cur]++;
        }
        
        return res;
    }
};