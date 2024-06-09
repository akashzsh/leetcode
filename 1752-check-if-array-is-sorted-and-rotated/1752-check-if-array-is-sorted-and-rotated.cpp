class Solution {
public:
    bool check(vector<int>& nums) {
        for (int i = 1, cnt = 0, n = nums.size(); i < 2 * n; i++) {
            if (nums[(i - 1) % n] <= nums[i % n]) {
                cnt++;
                if (cnt >= n - 1) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        
        return false;
    }
};


// 3 4 5 1 2    3 4 5 1 2