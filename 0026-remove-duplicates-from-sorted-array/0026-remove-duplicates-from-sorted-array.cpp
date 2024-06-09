class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        
        for (int j = 1, n = nums.size(); j < n; j++) {
            if (nums[i] != nums[j]) {
                i++;
                swap(nums[i], nums[j]);
            }
        }
        
        return i + 1;
    }
};