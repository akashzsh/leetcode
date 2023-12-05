class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = -1, sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        while (k-- > 0) {
            sum += max;
            max++;
        }
        return sum;
    }
}