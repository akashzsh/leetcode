class Solution {
public:
    int subarray_lte_k(vector<int>& nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        unordered_map<int, int> mp;
        int cnt = 0;
        
        for (int l = 0, r = 0, n = nums.size(), ones = 0; r < n; r++) {
            if (nums[r] == 1) {
                ones++;
            }
            mp[nums[r]]++;
            
            while (ones > k) {
                if (nums[l] == 1) {
                    ones--;
                }
                mp[nums[l]]--;
                if (mp[nums[l]] == 0) {
                    mp.erase(nums[l]);
                }
                l++;
            }
            
            cnt += (r - l + 1);
        }
        
        return cnt;
    }
    
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        return subarray_lte_k(nums, goal) - subarray_lte_k(nums, goal - 1);
    }
};