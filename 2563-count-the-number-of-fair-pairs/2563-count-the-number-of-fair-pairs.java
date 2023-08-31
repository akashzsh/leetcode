class Solution {
    private long f(int[] nums, int val, int n) {
        long cnt = 0;
        for (int i = 0, j = n - 1; i < j; i++) {
            while (i < j && nums[i] + nums[j] > val) j--;
            cnt += j - i;
        }
        return cnt;
    }
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        return f(nums, upper, n) - f(nums, lower - 1, n);
    }
}