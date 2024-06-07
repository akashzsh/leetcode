class Solution {
public:
    int subarray_lte_k(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        int cnt = 0;
        
        for (int l = 0, r = 0, n = nums.size(); r < n; r++) {
            mp[nums[r]]++;
            
            while (mp.size() > k) {
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
    
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return subarray_lte_k(nums, k) - subarray_lte_k(nums, k - 1);
    }
};