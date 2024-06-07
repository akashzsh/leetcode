class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        int res = 0;
        
        for (int l = 0, r = 0, n = nums.size(), flip = 0; r < n; r++) {
            if (nums[r] == 0) {
                flip++;
            }
            mp[nums[r]]++;
            
            while (flip > k) {
                if (nums[l] == 0) {
                    flip--;
                }
                mp[nums[l]]--;
                if (mp[nums[l]] == 0) mp.erase(nums[l]);
                l++;
            }
            
            res = max(res, r - l + 1);
        }
        
        return res;
    }
};