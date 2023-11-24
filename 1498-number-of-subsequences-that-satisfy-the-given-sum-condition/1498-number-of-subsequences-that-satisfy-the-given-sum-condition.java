class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007, n = nums.length;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int l = 0, h = n - 1, ans = 0;
        while (l <= h) {
            if (nums[l] + nums[h] > target) {
                h--;
            } else {
                ans = (ans + power[h - l]) % mod;
                l++;
            }
        }
        return ans;
    }
}