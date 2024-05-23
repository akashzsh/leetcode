class Solution {
public:
    int make_parts(int& mid, vector<int>& nums, int n) {
        int parts = 1, cur = 0;
        
        for (int i = 0; i < n; i++) {
            if (cur + nums[i] <= mid) {
                cur = cur + nums[i];
            } else {
                parts++;
                cur = nums[i];
            }
        }
        
        return parts;
    }
    
    int splitArray(vector<int>& nums, int k) {
        int low = 0, high = 0;
        
        for (int& it : nums) {
            low = max(low, it);
            high = high + it;
        }
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            
            int partitions = make_parts(mid, nums, nums.size());
            
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
};