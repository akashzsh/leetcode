class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int cnd = 0, cnt = 0;
        
        for (auto& it : nums) {
            if (cnt == 0) {
                cnt = 1;
                cnd = it;
            } else if (cnd == it) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        return cnd;
    }
};