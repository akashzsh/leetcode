class Solution {

  public static void swapArray(int[] arr, int start, int end) {
    int mid = (start + end + 1) / 2;
    for (int i = start; i < mid; i++, end--) {
      int temp = arr[i];
      arr[i] = arr[end];
      arr[end] = temp;
    }
  }

  public void rotate(int[] nums, int k) {
    if (k > nums.length) k %= nums.length;
    swapArray(nums, 0, nums.length - 1);
    swapArray(nums, 0, k - 1);
    swapArray(nums, k, nums.length - 1);
  }
}