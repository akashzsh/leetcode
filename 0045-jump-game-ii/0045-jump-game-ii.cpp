class Solution {
public:
    int jump(vector<int>& nums) {
        int curEnd = 0, jumps = 0, farthest = 0, N = nums.size();
        
        for (int i = 0; i < N - 1; i++) {
            farthest = max(farthest, i + nums[i]);
            
            if (i == curEnd) {
                jumps++;
                curEnd = farthest;
            }
        }
        
        return jumps;
    }
};