class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int res = 0, cur = 0;
        
        for (auto& it : nums) {
            if (it == 1) {
                cur++;
                res = max(res, cur);
            } else {
                cur = 0;
            }
        }
        
        return res;
    }
};