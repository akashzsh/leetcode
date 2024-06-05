class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        unordered_map<int, int> mp;
        
        mp[0] = 1;
        
        int cnt = 0;
        
        for (int i = 0, n = nums.size(), sum = 0; i < n; i++) {
            sum += nums[i];
            
            if (mp.find(sum - goal) != mp.end()) {
                cnt += mp[sum - goal];
            }
            
            mp[sum]++;
        }
        
        return cnt;
    }
};