class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        int res = 0;
        
        for (int i = 0, N = nums.size(), n = (1 << N); i < n; i++) {
            int cur = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j))) {
                    cur ^= nums[j];
                }
            }
            res = res + cur;
        }
        
        return res;
    }
};