class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, curMin = nums[k], left = k, right = k, ans = nums[k];
        
        while (left > 0 || right < n - 1) {
            if ((left > 0 ? nums[left - 1] : 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                right++;
                curMin = Math.min(curMin, nums[right]);
            } else {
                left--;
                curMin = Math.min(curMin, nums[left]);
            }
            ans = Math.max(ans, curMin * (right - left + 1));
        }
        
        return ans;
    }
}