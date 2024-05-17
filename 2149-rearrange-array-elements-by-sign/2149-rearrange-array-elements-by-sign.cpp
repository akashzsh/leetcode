class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int N = nums.size();
        
        vector<int> res(N);
        
        for (int i = 0, p = 0, n = 1; i < N; i++) {
            if (nums[i] >= 0) {
                res[p] = nums[i];
                p += 2;
            } else {
                res[n] = nums[i];
                n += 2;
            }
        }
        
        return res;
    }
};