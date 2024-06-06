class Solution {
public:
    int subarray_lte_k(vector<int>& nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        int cnt = 0;
        
        for (int l = 0, r = 0, n = nums.size(), odd = 0; r < n; r++) {
            if (nums[r] & 1) {
                odd++;
            }
            
            while (odd > k) {
                if (nums[l] & 1) {
                    odd--;
                }
                l++;
            }
            
            cnt += (r - l + 1);
        }
        
        return cnt;
    }
    
    int numberOfSubarrays(vector<int>& nums, int k) {
        return subarray_lte_k(nums, k) - subarray_lte_k(nums, k - 1);
    }
};