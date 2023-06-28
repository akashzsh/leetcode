class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] curr : nums) Arrays.sort(curr);
        int n = nums[0].length - 1, sum = 0;
        while (n >= 0) {
            int max = -1;
            for (int[] curr : nums) {
                max = Math.max(curr[n], max);
            }
            sum += max;
            n--;
        }
        return sum;
    }
}