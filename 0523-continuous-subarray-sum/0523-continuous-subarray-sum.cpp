class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        // mp logical name is first_seen
        unordered_map<int, int> mp;
        
        int prefix = 0;
        
        // at idx = -1 there is prefix sum of 0 (means before start)
        mp[0] = -1;
        
        for (int i = 0, n = nums.size(); i < n; i++) {
            prefix += nums[i];
            
            int tmp = prefix % k;
            
            if (mp.find(tmp) == mp.end()) {
                mp[tmp] = i;
            } else {
                if (i - mp[tmp] >= 2) {
                    return true;
                }
            }
        }
        
        // for (auto& it : mp) cout << it.first << " and " << it.second << "\n";
        // cout << "\n";
        
        return false;
    }
};