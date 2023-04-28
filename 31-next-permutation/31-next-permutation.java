class Solution {
    
    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int pivot = -1, q;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        if (pivot != -1)
            for (int i = nums.length - 1; i >=0; --i) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        
        reverse(nums, pivot + 1, nums.length - 1);
    }
}