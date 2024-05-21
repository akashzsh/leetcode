class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;
        
        if (low == high || nums[low] > nums[low + 1]) {
            return low;
        }
        
        if (nums[high] > nums[high - 1]) {
            return high;
        }
        
        low++;
        high--;
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
};