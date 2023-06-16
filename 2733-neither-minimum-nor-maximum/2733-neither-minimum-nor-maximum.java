class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[n - 1];
        for (int i : nums) {
            if (i != smallest && i != largest) return i;
        }
        return -1;
    }
}