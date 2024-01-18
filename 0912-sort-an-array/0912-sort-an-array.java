class Solution {
    public void merge(int[] nums, int low, int mid, int high) {
        int[] vec = new int[high - low + 1];
        
        int left = low, right = mid + 1, k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                vec[k] = nums[left++];
            } else {
                vec[k] = nums[right++];
            }
            k++;
        }
        
        while (left <= mid) {
            vec[k++] = nums[left++];
        }
        
        while (right <= high) {
            vec[k++] = nums[right++];
        }
        
        for (int i = 0; i < vec.length; i++) {
            nums[low + i] = vec[i];
        }
    }
    
    public void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}