class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int px = 1, sx = 1, res = INT_MIN;
        
        for (int i = 0, n = nums.size(); i < n; i++) {
            px = px * nums[i];
            res = max(res, px);
            if (px == 0) {
                px = 1;
            }
            
            sx = sx * nums[n - 1 - i];
            res = max(res, sx);
            if (sx == 0) {
                sx = 1;
            }
        }
        
        return res;
    }
};