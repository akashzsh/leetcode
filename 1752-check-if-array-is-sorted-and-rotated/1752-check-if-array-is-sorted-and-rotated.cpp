class Solution {
public:
    bool check(vector<int>& nums) {
        int N = nums.size(), cnt = 0;
        
        if (N == 1) {
            return true;
        }
        
        for (int i = 1; i < 2 * N; i++) {
            if (nums[(i - 1) % N] <= nums[i % N]) {
                cnt++;
                if (cnt == N - 1) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        
        return false;
    }
};

/*
 0 1 2 3 4  5 6 7 8 9
[3,4,5,1,2, 3,4,5,1,2]
*/