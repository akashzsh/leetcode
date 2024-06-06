class Solution {
public:
    int subarray_lte_k(vector<int>& nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        int cnt = 0;
        
        for (int l = 0, r = 0, n = nums.size(), sum = 0; r < n; r++) {
            sum += nums[r];
            
            while (sum > k) {
                sum -= nums[l];
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