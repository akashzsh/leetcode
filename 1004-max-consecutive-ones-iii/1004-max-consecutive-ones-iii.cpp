class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int res = 0;
        
        for (int l = 0, r = 0, n = nums.size(), flip = 0; r < n; r++) {
            if (nums[r] == 0) {
                flip++;
            }
            
            while (flip > k) {
                if (nums[l] == 0) {
                    flip--;
                }
                l++;
            }
            
            res = max(res, r - l + 1);
        }
        
        return res;
    }
};