class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, reachable = 0;
        for (int i = 0; i < n; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}