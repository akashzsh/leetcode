class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0, target = 0, cur = 0, maxLen = -1;
        for (int i = 0; i < n; i++) sum += nums[i];
        target = sum - x;
        for (int l = 0, r = 0; r < n; r++) {
            cur += nums[r];
            while (l <= r && cur > target) cur -= nums[l++];
            if (cur == target) maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}