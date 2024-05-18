class Solution {
public:
    void f(int i, vector<int>& nums) {
        i = i + 1;
        nums.resize(i, 0);
        for (int j = 0; j < i; j++) {
            if (j == 0) {
                nums[j] = 1;
            } else {
                nums[j] = (nums[j - 1] * (i - j)) / j;
            }
        }
    }
    
    vector<vector<int>> generate(int n) {
        vector<vector<int>> res(n, vector<int>());
        
        for (int i = 0; i < n; i++) {
            f(i, res[i]);
        }
        
        return res;
    }
};