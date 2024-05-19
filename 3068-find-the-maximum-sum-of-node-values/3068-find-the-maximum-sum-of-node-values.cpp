class Solution {
public:
    typedef long long ll;
    
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        int n = nums.size(), cnt = 0, min_loss = INT_MAX;
        ll ideal_sum = 0;
        
        for (int i = 0; i < n; i++) {
            int cur = nums[i] ^ k;
            
            if (cur < nums[i]) {
                ideal_sum += nums[i];
            } else {
                cnt++;
                ideal_sum += cur;
            }
            
            min_loss = min((ll)min_loss, (ll)abs(nums[i] - cur));
        }
        
        if (cnt & 1) {
            ideal_sum -= min_loss;
        }
        
        return ideal_sum;
    }
};