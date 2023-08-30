class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) continue;
            int el;
            if (nums[i] % nums[i + 1] == 0) {
                el = nums[i] / nums[i + 1];
            } else {
                el = nums[i] / nums[i + 1] + 1;
            }
            cnt += el - 1;
            nums[i] = nums[i] / el;
        }
        return cnt;
    }
}