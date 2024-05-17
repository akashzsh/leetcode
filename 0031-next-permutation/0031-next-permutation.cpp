class Solution {
public:
    void reverse(vector<int>& nums, int start, int end) {
        while (start < end) {
            swap(nums[start], nums[end]);
            start++;
            end--;
        }
    }
    
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        
        int p = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        
        if (p == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        int q = p + 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[p]) {
                swap(nums[i], nums[p]);
                break;
            }
        }
        
        reverse(nums, q, n - 1);
    }
};