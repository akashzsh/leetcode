class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        
        int cnt = 0;
        
        mp[0] = 1;
        
        for (int i = 0, n = nums.size(), ps = 0; i < n; i++) {
            ps += nums[i];
            
            // cout << "PS IS " << ps << "\n";
            
            int rem = ps % k;
            
            if (rem < 0) {
                rem = rem + k;
            }
            
            // cout << "REM IS " << rem << "\n";
            
            cnt += mp[rem];
            
            mp[rem]++;
        }
        
        return cnt;
    }
};