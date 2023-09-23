class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int idx = 0, cnt = 0, n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                idx = i;
                cnt++;
            }
        }
        if (cnt > 1) return -1;
        if (cnt == 0) return 0;
        return nums.get(n - 1) < nums.get(0) ? n - idx : -1;
    }
}