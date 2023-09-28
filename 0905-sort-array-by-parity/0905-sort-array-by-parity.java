class Solution {
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 0) i++;
            else {
                if (nums[j] % 2 == 0) {
                    swap(i, j, nums);
                    i++;
                }
                j--;
            }
        }
        return nums;
    }
}