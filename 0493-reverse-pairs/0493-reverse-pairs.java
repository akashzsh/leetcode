class Solution {
    public void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int p = low; p <= high; p++) {
            nums[p] = temp[p - low];
        }
    }
    
    public int countPairs(int[] nums, int low, int mid, int high) {
        int cnt = 0, j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }
        return cnt;
    }
    
    public int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = low + ((high - low) >> 1);
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}