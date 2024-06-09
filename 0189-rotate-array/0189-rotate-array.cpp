class Solution {
public:
    void reversing(vector<int>& nums, int l, int r) {
        while (l < r) {
            swap(nums[l++], nums[r--]);
        }
    }
    
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        
        k = k % n;
        
        reversing(nums, 0, n - k - 1);
        reversing(nums, n - k, n - 1);
        reversing(nums, 0, n - 1);
    }
};