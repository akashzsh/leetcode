class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, sum = 0, tmp = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            tmp += (nums[i] * i);
        }
        int maxi = tmp;
        for (int i = 1; i < n; i++) {
            tmp = tmp - sum + nums[i - 1] * n;
            if (tmp > maxi) maxi = tmp;
        }
        return maxi;
    }
}