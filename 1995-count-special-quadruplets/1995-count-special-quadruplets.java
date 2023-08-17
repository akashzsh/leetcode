class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int m = k + 1; m < n; m++) {
                        if (nums[i] + nums[j] + nums[k] == nums[m]) cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}