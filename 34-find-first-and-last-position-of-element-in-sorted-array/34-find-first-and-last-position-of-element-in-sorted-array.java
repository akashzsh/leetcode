class Solution {
    
    public int searchFirst(int[] nums, int target, int flag) {
        int low = 0, high = nums.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else {
                ans = mid;
                if (flag == 1) high = mid - 1;
                else low = mid + 1;
            }
        }
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = searchFirst(nums, target, 1);
        if (result[0] != -1) result[1] = searchFirst(nums, target, 0);
        return result;
    }
}