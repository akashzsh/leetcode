class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) return 0;
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int cur = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - cur) < Math.abs(target - closest)) {
                    closest = cur;
                }
                if (cur < target) j++;
                else k--;
            }
        }
        return closest;
    }
}