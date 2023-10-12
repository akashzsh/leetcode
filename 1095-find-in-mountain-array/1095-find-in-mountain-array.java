class Solution {
    private int binarySearch(MountainArray nums, int target, int rev, int low, int high)
    {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums.get(mid) == target) return mid;
            if (nums.get(mid) > target) {
                if (rev == 0) high = mid - 1;
                else low = mid + 1;
            } else {
                if (rev == 0) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
    
    private int find(MountainArray nums) {
        int low = 0, high = nums.length() - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums.get(mid) < nums.get(mid + 1)) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakPosition = find(mountainArr);
        int left = binarySearch(mountainArr, target, 0, 0, peakPosition);
        if (left != -1) return left;
        return binarySearch(mountainArr, target, 1, peakPosition + 1, mountainArr.length() - 1);
    }
}