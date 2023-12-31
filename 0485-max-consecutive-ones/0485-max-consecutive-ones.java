class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}