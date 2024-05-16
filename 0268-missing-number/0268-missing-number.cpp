class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size(), xr = 0;
        
        for (int i = 0; i <= n; i++) {
            xr = xr ^ i;
        }
        
        for (auto& it : nums) {
            xr = xr ^ it;
        }
        
        return xr;
    }
};