class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (low == high || nums[low] != nums[low + 1]) {
            return nums[low];
        }
        if (nums[high] != nums[high - 1]) {
            return nums[high];
        }
        low++;
        high--;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] == nums[mid + 1] && mid % 2 == 0 || nums[mid] == nums[mid - 1] && mid % 2 != 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}